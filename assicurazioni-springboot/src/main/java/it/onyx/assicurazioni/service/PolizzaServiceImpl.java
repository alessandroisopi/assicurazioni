package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.context.UserContext;
import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.dtoNoEntity.PolizzaInsert;
import it.onyx.assicurazioni.entity.*;
import it.onyx.assicurazioni.repository.ClasseRepository;
import it.onyx.assicurazioni.repository.PolizzaRepository;
import it.onyx.assicurazioni.repository.StatoPolizzaRepository;
import it.onyx.assicurazioni.repository.TipoPolizzaRepository;
import it.onyx.assicurazioni.util.ClasseMapper;
import it.onyx.assicurazioni.util.PolizzaMapper;
import it.onyx.assicurazioni.util.StatoPolizzaMapper;
import it.onyx.assicurazioni.util.TipoPolizzaMapper;
import jakarta.transaction.Transactional;
import onyx.classi.generated.DtoCittadino;
import onyx.classi.generated.ImmatricolatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PolizzaServiceImpl implements PolizzaService {
    @Autowired
    private PolizzaRepository polizzaRepository;

    @Autowired
    private TipoPolizzaRepository tipoPolizzaRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private StatoPolizzaRepository statoPolizzaRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.persone}")
    private String persone;

    @Value("${url.registro}")
    private String registro;

    @Override
    public PolizzaDTO insert(PolizzaDTO dto) {
        try {
            dto.setDtInserimento(LocalDateTime.now());
            dto.setCombinato();
            Polizza polizza = PolizzaMapper.toEntity(dto);    //conversione a entità del dto
            if (tipoPolizzaRepository.findById(dto.getIdTipoPolizza().getIdTipoPolizza()).isEmpty()) {
                return null;
            }
            TipoPolizza tipoPolizza = tipoPolizzaRepository.findById(dto.getIdTipoPolizza().getIdTipoPolizza()).get();  //ottiene il tipo di polizza tramite l'id
            polizza.setIdTipoPolizza(tipoPolizza);  //viene settato il tipo di polizza
            if (classeRepository.findById(dto.getIdClasse().getIdClasse()).isEmpty()) {
                return null;
            }
            Classe classe = classeRepository.findById(dto.getIdClasse().getIdClasse()).get();   //ottiene la classe della polizza tramite l'id
            polizza.setIdClasse(classe);    //viene settata la classe
            if (statoPolizzaRepository.findById(dto.getIdStatoPolizza().getIdStatoPolizza()).isEmpty()) {
                return null;
            }
            StatoPolizza statoPolizza = statoPolizzaRepository.findById(dto.getIdStatoPolizza().getIdStatoPolizza()).get();
            polizza.setIdStatoPolizza(statoPolizza);
            if(dto.getDtFine().isBefore(dto.getDtInizio())) {   //controllo che la data sia coerente
                return null;
            }
            polizza.setUtenteC(UserContext.getUtente().getCodiceFiscale());
            Polizza controlloPolizzaVecchia = polizzaRepository.getById(polizza.getId().getIdPolizza());
            if (controlloPolizzaVecchia != null) {
                delete((controlloPolizzaVecchia.getId().getIdPolizza()));
            }
            polizza.setValido(1);
            return PolizzaMapper.toDto(polizzaRepository.save(polizza));  //effettua il salvataggio sia nel database che nella variabile
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<PolizzaDTO> getAll() {
        try {
            List<PolizzaDTO> result = new ArrayList<>();    //crea la lista per il risultato
            for (Polizza p : polizzaRepository.findAll()) { //itera tutta la tabella e inserisce ogni riga nella lista
                result.add(PolizzaMapper.toDto(p));
            }
            return result;
        }  catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public PolizzaDTO getById(long idPolizza) {
        try {
            Polizza polizza = polizzaRepository.getById(idPolizza); //richiama la query nativa
            if  (polizza == null) {
                return null;
            }
            return PolizzaMapper.toDto(polizza);
        }  catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public PolizzaDTO update(PolizzaDTO dto) {
       try {
           if (polizzaRepository.getById(dto.getIdPolizza()) == null) {
               return null;
           }
           Polizza polizzaDB = polizzaRepository.getById(dto.getIdPolizza());
           //controlla l'esistenza dell'oggetto
           if (dto.getIdTipoPolizza() == null) {  //una serie di if che controlla campo per campo, se nulli vengono rimpiazzati con quelli da database
               dto.setIdTipoPolizza(TipoPolizzaMapper.toDto(polizzaDB.getIdTipoPolizza()));
           }
           if (dto.getIdClasse() == null) {
               dto.setIdClasse(ClasseMapper.toDto(polizzaDB.getIdClasse()));
           }
           if (dto.getCdIntestatario().isEmpty()) {
               dto.setCdIntestatario(polizzaDB.getCdIntestatario());
           }
           if (dto.getIdStatoPolizza() == null) {
               dto.setIdStatoPolizza(StatoPolizzaMapper.toDto(polizzaDB.getIdStatoPolizza()));
           }
           if (dto.getDtInizio() == null) {
               dto.setDtInizio(polizzaDB.getDtInizio());
           }
           if (dto.getDtFine() == null) {
               dto.setDtFine(polizzaDB.getDtFine());
           }
           if (dto.getNote() == null) {
               dto.setNote(polizzaDB.getNote());
           }
           if(dto.getDtFine().isBefore(dto.getDtInizio())) {    // controllo che la data sia coerente
               return null;
           }
           dto.setCombinato();  //viene reimpostato il campo numPolizza
           dto.setUtenteC(UserContext.getUtente().getCodiceFiscale());
           dto.setDtInserimento(LocalDateTime.now());
           dto.setValido(1);
           polizzaDB.setValido(0);
           polizzaRepository.save(polizzaDB);
           return PolizzaMapper.toDto(polizzaRepository.save(PolizzaMapper.toEntity(dto))); //viene salvato e il ritornato

       } catch (Exception e) {
           System.err.println(e.getMessage());
           throw e;
       }
    }

    @Override
    public boolean delete(long idPolizza) {
        try {
            Polizza polizza = polizzaRepository.getById(idPolizza);
            if (polizza != null) { //controlla l'esistenza
                polizza.setValido(0);
                polizzaRepository.save(polizza);
                return true;    //torna true
            } else  {   //non esiste torna false
                return false;
            }
        }  catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public boolean verificaStatoPolizza(String cd) {
        try {
            Polizza result = polizzaRepository.getByCdIntestatario(cd);
            return result != null;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public PolizzaDTO insertControllata(PolizzaInsert dto) throws Exception {
        //recupera il cittadino con il codice fiscale che ho tramite il servizio persone
        //scrive la url
        String urlGetCittadinoByCf = persone + "persona/cittadinoByCf/" + dto.getContraente().getCf();
        //crea gli header necessari
        HttpHeaders headers = new HttpHeaders();
        headers.set("nome", UserContext.getUtente().getNome());
        headers.set("cognome", UserContext.getUtente().getCognome());
        headers.set("codFiscale", UserContext.getUtente().getCodiceFiscale());
        headers.set("dtNascita", UserContext.getUtente().getDataNascita().toString());
        HttpEntity<String> listaHeaders = new HttpEntity<>(headers);
        //manda la richiesta
        ResponseEntity<DtoCittadino> responseCittadino = restTemplate.exchange(
          urlGetCittadinoByCf,
          HttpMethod.GET,
          listaHeaders,
          DtoCittadino.class
        );
        //ottiene il risultato ed effettua controlli
        DtoCittadino dtoCittadino = getDtoCittadino(dto, responseCittadino);
        //controlla se la polizza si tratta di RCA(2) o sulla vita(1)
        if (dto.getTipoPolizza().getIdTipoPolizza() == 2) {
            //recupera tutti i telai di una persona tramite codice fiscale con il servizio di persone
            //scrive la url necessaria
            String urlgetAllTelai = persone + "veicoloCitt/getAllTelaiDiCitt?codiceFiscale=" + dto.getContraente().getCf();
            //crea il tipo di risposta che mi aspetto dal metodo
            ParameterizedTypeReference<List<String>> responseListString = new ParameterizedTypeReference<>() {};
            //manda la richiesta
            ResponseEntity<List<String>> responseAllTelai = restTemplate.exchange(
                    urlgetAllTelai,
                    HttpMethod.GET,
                    listaHeaders,
                    responseListString
            );
            //ottiene i risultati
            List<String> telai = responseAllTelai.getBody();
            //se non viene trovato nulla lancia un'eccezione
            if (telai == null) {
                throw new Exception("Ritornata lista di telai nulla");
            }
            //ora devo controllare se tra tutti i telai che ha uno corrisponde con una targa in immatricolata a suo nome
            //variabile solo per controllare se il veicolo è stato trovato
            boolean controlloVeicolo = false;
            //crea il tipo di risposta che mi aspetto dal metodo
            ParameterizedTypeReference<List<ImmatricolatoDTO>> responseListImmatricolato = new ParameterizedTypeReference<>() {};
            //itera tutti i telai del cittadino
            //per ogni telaio viene fatta una chiamata al servizio di registro automobilistico
            for (String telaio : telai) {
                String urlgetImmatricolatoByTelaio = registro + "immatricolato/telaio/" + telaio;
                ResponseEntity<List<ImmatricolatoDTO>> responseImmatricolato = null;
                try {
                    responseImmatricolato = restTemplate.exchange(
                      urlgetImmatricolatoByTelaio,
                      HttpMethod.GET,
                      listaHeaders,
                      responseListImmatricolato
                    );
                } catch (RestClientException e) {
                    //messaggio di errore in console se non viene trovato nessun veicolo
                    System.err.println(e.getMessage());
                }
                if (responseImmatricolato != null) {
                    if (responseImmatricolato.getBody() != null) {
                        //se la risposta è completa e non manca nulla itera il body
                        //controlla se la targa di ogni immatricolazione estratta corrisponde a quella passata
                        //se c'è un match viene segnalato dalla variabile booleana che è stato trovato qualcosa e termina tutti i cicli
                        for (ImmatricolatoDTO immatricolatoDTO : responseImmatricolato.getBody()) {
                            if (immatricolatoDTO.getDsTarga().equals(dto.getCdIntestatario())) {
                                controlloVeicolo = true;
                                break;
                            }
                        }
                    }
                }
                if (controlloVeicolo) {
                    break;
                }
            }
            //se non viene trovato nulla la variabile di controllo rimarrà false e lancerà un'eccezione
            if (!controlloVeicolo) {
                throw new Exception("La targa non è associata alla persone con questo codice fiscale");
            }
            //inizia a costruire l'oggetto da salvare in database
            Polizza result = new Polizza();
            //viene fatta una query che controlla se il cittadino ha mai avuto una polizza assicurativa
            Polizza controlloClasse = polizzaRepository.getAllByCd(dto.getCdIntestatario());
            //se non ce l'ha avuta gli assegna un id nuovo, la classe 14 e la data di inizio viene messa a oggi
            if (controlloClasse == null) {
                //prende l'ultimo id inserito
                long idMax = polizzaRepository.countMax();
                //utilizza l'ultimo id inserito più uno per assegnare l'id insieme alla data e ora di questo istante
                result.setId(new PolizzaEmbeddedId(idMax + 1, LocalDateTime.now()));
                //controlla se non ci sono problemi con la classe ed esiste ancora la classe 14
                if (classeRepository.findById(14L).isPresent()) {
                    result.setIdClasse(classeRepository.findById(14L).get());
                } else {
                    //se non esiste lancia un eccezione
                    throw new Exception("Errore inserimento classe");
                }
                //imposta la data di inizio della polizza al giorno stesso
                result.setDtInizio(LocalDate.now());
            } else {
                //qui si entra se il cittadino ha avuto una polizza
                //per l'id utilizza quello già esistente e aggiunge la data e ora di oggi
                result.setId(new PolizzaEmbeddedId(controlloClasse.getId().getIdPolizza(), LocalDateTime.now()));
                //controlla se la polizza precedente viene da meno di due anni
                if (LocalDate.now().isBefore(controlloClasse.getDtFine().minusYears(2))) {
                    //nel caso fosse così viene assegnata la classe dopo se si trova dalla 2 in giù
                    if (controlloClasse.getIdClasse().getIdClasse() == 1) {
                        result.setIdClasse(controlloClasse.getIdClasse());
                    } else {
                        if (classeRepository.findById(controlloClasse.getIdClasse().getIdClasse() + 1).isPresent()) {
                            result.setIdClasse(classeRepository.findById(controlloClasse.getIdClasse().getIdClasse() + 1).get());
                        } else {
                            throw new Exception("Errore inserimento classe");
                        }
                    }
                } else {
                    //altrimenti viene assegnata in automatico la classe 14
                    if (classeRepository.findById(14L).isPresent()) {
                        result.setIdClasse(classeRepository.findById(14L).get());
                    } else {
                        throw new Exception("Errore inserimento classe");
                    }
                }
                result.setDtInizio(LocalDate.now());
            }

            //controlla se ci sono problemi con il tipo della polizza
            if (tipoPolizzaRepository.findById(dto.getTipoPolizza().getIdTipoPolizza()).isEmpty()) {
                throw new  Exception("Errore inserimento tipo polizza");
            }
            //imposta il tipo di polizza nell'oggetto da salvare
            result.setIdTipoPolizza(tipoPolizzaRepository.findById(dto.getTipoPolizza().getIdTipoPolizza()).get());
            //imposta il codice dell'intestatario, che in questo caso sarà la targa
            result.setCdIntestatario(dto.getCdIntestatario());
            //controlla se ci sono problemi per impostare lo stato della polizza
            if (statoPolizzaRepository.findById(4L).isEmpty()) {
                throw new Exception("Errore inserimento stato polizza");
            }
            //mette di base come stato in attesa da pagare
            result.setIdStatoPolizza(statoPolizzaRepository.findById(4L).get());
            //imposta la data di fine della polizza che sarà sempre un anno in più all'inizio
            result.setDtFine(result.getDtInizio().plusYears(1));
            //imposta la nota di base
            result.setNote("Polizza RCA Standard");
            //imposta chi ha effettuato le modifiche
            result.setUtenteC(UserContext.getUtente().getCodiceFiscale());
            //imposta il numero della polizza
            result.setCombinato();
            if (polizzaRepository.getById(result.getId().getIdPolizza()) != null) {
                delete(result.getId().getIdPolizza());
            }
            result.setValido(1);
            //salva la polizza sul database
            polizzaRepository.save(result);
            //ritorna l'oggetto completo
            return PolizzaMapper.toDto(result);
        } else if (dto.getTipoPolizza().getIdTipoPolizza() == 1) {
            //controlla se il cittadino ha più di 14 anni ed è vivo
            if (Period.between(LocalDate.parse(dtoCittadino.getDataNascitaDto()), LocalDate.now()).getYears() > 14 && dtoCittadino.getIdStatoCittadinoDto().getIdStatoCittadinoDto() != 2) {
                Polizza result = new Polizza();
                long idMax = polizzaRepository.countMax();
                //imposta l'id ma molto probabilmente andrà modificato
                result.setId(new PolizzaEmbeddedId(idMax + 1, LocalDateTime.now()));
                //imposta il tipo polizza come polizza vita
                result.setIdTipoPolizza(tipoPolizzaRepository.findById(dto.getTipoPolizza().getIdTipoPolizza()).get());
                //imposta la classe come prima temporaneamente
                if (classeRepository.findById(1L).isEmpty()) {
                    throw new Exception("Errore inserimento classe");
                }
                result.setIdClasse(classeRepository.findById(1L).get());
                //controlla se l'intestatario è coerente con il contraente e lo imposta
                if (!dto.getCdIntestatario().equals(dtoCittadino.getCodiceFiscaleDto())) {
                    throw new Exception("Errore codice fiscale tra contraente e intestatario");
                }
                result.setCdIntestatario(dto.getCdIntestatario());
                //imposta lo stato come da pagare
                result.setIdStatoPolizza(statoPolizzaRepository.findById(4L).get());
                //imposta la data di inizio a oggi
                result.setDtInizio(LocalDate.now());
                //imposta la data di fine dopo un anno di quella di inizio
                result.setDtFine(result.getDtInizio().plusYears(1));
                //imposta la nota standard
                result.setNote("Polizza Vita Standard");
                //imposta l'utente che ha effettuato questa insert
                result.setUtenteC(UserContext.getUtente().getCodiceFiscale());
                if (polizzaRepository.getById(result.getId().getIdPolizza()) != null) {
                    delete(result.getId().getIdPolizza());
                }
                result.setValido(1);
                //imposta il numero della polizza
                result.setCombinato();
                polizzaRepository.save(result);
                return PolizzaMapper.toDto(result);
            }
        } else {
            throw new  Exception("Tipo di polizza non gestita in questo servizio");
        }
        throw new Exception("Errore inserimento polizza");
    }

    private static DtoCittadino getDtoCittadino(PolizzaInsert dto, ResponseEntity<DtoCittadino> responseCittadino) throws Exception {
        DtoCittadino dtoCittadino = responseCittadino.getBody();
        //controlla se il cittadino è nullo
        if  (dtoCittadino == null) {
            throw new Exception("Ritornato un cittadino nullo");
        }
        //controlla se il nome corrisponde
        if  (!dtoCittadino.getNomeCittadinoDto().equals(dto.getContraente().getNome())) {
            throw new Exception("Nome non valido");
        }
        //controlla il cognome
        if (!dtoCittadino.getCognomeCittadinoDto().equals(dto.getContraente().getCognome())) {
            throw new Exception("Cognome non valido");
        }
        //controlla se ci sono stati risultati altrimenti lancia un eccezione
        if (!dtoCittadino.getDataNascitaDto().equals(dto.getContraente().getDtNascita().toString())) {
            throw new Exception("Data di nascita non valida");
        }
        return dtoCittadino;
    }
}

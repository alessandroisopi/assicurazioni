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
            if (polizzaRepository.existsById(new PolizzaEmbeddedId(dto.getIdClasse().getIdClasse(), dto.getDtInserimento()))) {
                return null;
            }
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
            polizza = polizzaRepository.save(polizza);  //effettua il salvataggio sia nel database che nella variabile
            if (polizzaRepository.existsById(polizza.getId())) { //controllo se andato tutto bene
                return PolizzaMapper.toDto(polizza);
            } else {
                return null;
            }
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
           PolizzaEmbeddedId id = new PolizzaEmbeddedId(dto.getIdPolizza(), dto.getDtInserimento());
           if (polizzaRepository.findById(id).isPresent()) { //controlla l'esistenza dell'oggetto
               Polizza polizzaDB = polizzaRepository.findById(id).get();   //prende il campo nel db per riempire le colonne che non devono essere aggiornate
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
               return PolizzaMapper.toDto(polizzaRepository.save(PolizzaMapper.toEntity(dto))); //viene salvato e il ritornato
           } else {
               return null;
           }
       } catch (Exception e) {
           System.err.println(e.getMessage());
           throw e;
       }
    }

    @Override
    public boolean delete(long idPolizza, LocalDateTime dtInserimento) {
        try {
            PolizzaEmbeddedId id = new PolizzaEmbeddedId(idPolizza, dtInserimento); //viene creato direttamente l'oggetto della chiave composta per comodità
            if (polizzaRepository.existsById(id)) { //controlla l'esistenza
                polizzaRepository.deleteById(id);   //lo elimina
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
        String urlGetCittadinoByCf = persone + "persona/cittadinoByCf/" + dto.getContraente().getCf();
        HttpHeaders headers = new HttpHeaders();
        headers.set("nome", UserContext.getUtente().getNome());
        headers.set("cognome", UserContext.getUtente().getCognome());
        headers.set("codFiscale", UserContext.getUtente().getCodiceFiscale());
        headers.set("dtNascita", UserContext.getUtente().getDataNascita().toString());
        HttpEntity<String> listaHeaders = new HttpEntity<>(headers);
        ResponseEntity<DtoCittadino> responseCittadino = restTemplate.exchange(
          urlGetCittadinoByCf,
          HttpMethod.GET,
          listaHeaders,
          DtoCittadino.class
        );
        DtoCittadino dtoCittadino = responseCittadino.getBody();
        if  (dtoCittadino == null) {
            throw new Exception("Ritornato un cittadino nullo");
        }
        if  (!dtoCittadino.getNomeCittadinoDto().equals(dto.getContraente().getNome())) {
            throw new Exception("Nome non valido");
        }
        if (!dtoCittadino.getCognomeCittadinoDto().equals(dto.getContraente().getCognome())) {
            throw new Exception("Cognome non valido");
        }
        if (!dtoCittadino.getDataNascitaDto().equals(dto.getContraente().getDtNascita().toString())) {
            throw new Exception("Data di nascita non valida");
        }
        if (dto.getTipoPolizza().getIdTipoPolizza() == 2) { //se entra qua sta in RCA
            String urlgetAllTelai = persone + "veicoloCitt/getAllTelaiDiCitt?codiceFiscale=" + dto.getContraente().getCf();
            ParameterizedTypeReference<List<String>> responseListString = new ParameterizedTypeReference<>() {};
            ResponseEntity<List<String>> responseAllTelai = restTemplate.exchange(
                    urlgetAllTelai,
                    HttpMethod.GET,
                    listaHeaders,
                    responseListString
            );
            List<String> telai = responseAllTelai.getBody();
            if (telai == null) {
                throw new Exception("Ritornata lista di telai nulla");
            }
            //da qui mi serve il metodo di marim

            boolean controlloVeicolo = false;
            ParameterizedTypeReference<List<ImmatricolatoDTO>> responseListImmatricolato = new ParameterizedTypeReference<>() {};
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
                    System.err.println(e.getMessage());
                }
                if (responseImmatricolato != null) {
                    if (responseImmatricolato.getBody() != null) {
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

            if (!controlloVeicolo) {
                throw new Exception("La targa non è associata alla persone con questo codice fiscale");
            }
            //continua i controlli e i vari set
            Polizza result = new Polizza();
            Polizza controlloClasse = polizzaRepository.getAllByCd(dto.getCdIntestatario());
            if (controlloClasse == null) {
                long idMax = polizzaRepository.countMax();
                result.setId(new PolizzaEmbeddedId(idMax + 1, LocalDateTime.now()));
                if (classeRepository.findById(14L).isPresent()) {
                    result.setIdClasse(classeRepository.findById(14L).get());
                } else {
                    throw new Exception("Errore inserimento classe");
                }
                result.setDtInizio(LocalDate.now());
            } else {
                result.setId(new PolizzaEmbeddedId(controlloClasse.getId().getIdPolizza(), LocalDateTime.now()));
                if (LocalDate.now().isBefore(controlloClasse.getDtFine().minusYears(2))) {
                    result.setIdClasse(controlloClasse.getIdClasse());
                } else {
                    if (classeRepository.findById(14L).isPresent()) {
                        result.setIdClasse(classeRepository.findById(14L).get());
                    } else {
                        throw new Exception("Errore inserimento classe");
                    }
                }
                result.setDtInizio(controlloClasse.getDtFine().plusDays(1));
            }

            if (tipoPolizzaRepository.findById(dto.getTipoPolizza().getIdTipoPolizza()).isEmpty()) {
                throw new  Exception("Errore inserimento tipo polizza");
            }
            result.setIdTipoPolizza(tipoPolizzaRepository.findById(dto.getTipoPolizza().getIdTipoPolizza()).get());
            result.setCdIntestatario(dto.getCdIntestatario());
            if (statoPolizzaRepository.findById(4L).isEmpty()) {
                throw new Exception("Errore inserimento stato polizza");
            }
            result.setIdStatoPolizza(statoPolizzaRepository.findById(4L).get());
            result.setDtFine(result.getDtInizio().plusYears(1));
            result.setNote("Polizza RCA Standard");
            result.setUtenteC(UserContext.getUtente().getCodiceFiscale());
            result.setCombinato();
            polizzaRepository.save(result);
            return PolizzaMapper.toDto(result);
        } else if (dto.getTipoPolizza().getIdTipoPolizza() == 1) {
            if (Period.between(LocalDate.parse(dtoCittadino.getDataNascitaDto()), LocalDate.now()).getYears() > 14 && dtoCittadino.getIdStatoCittadinoDto() != 2) {
                Polizza result = new Polizza();

            }
        }
        return null;
    }
}

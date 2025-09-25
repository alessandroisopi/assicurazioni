package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.context.UserContext;
import it.onyx.assicurazioni.dto.PolizzaDTO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public boolean delete(long idPolizza, LocalDate dtInserimento) {
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
    public PolizzaDTO insertControl() {
        return null;
    }
}

package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.entity.Polizza;
import it.onyx.assicurazioni.entity.TipoPolizza;
import it.onyx.assicurazioni.repository.PolizzaRepository;
import it.onyx.assicurazioni.repository.TipoPolizzaRepository;
import it.onyx.assicurazioni.util.PolizzaMapper;
import it.onyx.assicurazioni.util.TipoPolizzaMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PolizzaServiceImpl implements PolizzaService {
    @Autowired
    private PolizzaRepository polizzaRepository;

    @Autowired
    private TipoPolizzaRepository tipoPolizzaRepository;

    @Override
    public PolizzaDTO insert(PolizzaDTO dto) {
        try {
            dto.setCombinato();
            Polizza polizza = PolizzaMapper.daPolizzaDTOAPolizza(dto);    //conversione ad entità del dto
            TipoPolizza tipoPolizza = tipoPolizzaRepository.findById(dto.getIdTipoPolizza().getIdTipoPolizza()).get();
            polizza.setIdTipoPolizza(tipoPolizza);
            if(dto.getDtFine().isBefore(dto.getDtInizio())) {   //controllo che la data sia coerente
                return null;
            }
            polizza = polizzaRepository.save(polizza);  //effetua il salvataggio sia nel database che nella variabile
            if (polizzaRepository.existsById(polizza.getIdPolizza())) { //controllo se andato tutto bene
                return PolizzaMapper.daPolizzaAPolizzaDTO(polizza);
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
            List<PolizzaDTO> result = new ArrayList<>();    //istanziata lista per il risultato
            for (Polizza p : polizzaRepository.findAll()) { //itera tutta la tabella e inserisce ogni riga nella lista
                result.add(PolizzaMapper.daPolizzaAPolizzaDTO(p));
            }
            return result;
        }  catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public PolizzaDTO getById(long id) {
        try {
            if (polizzaRepository.existsById(id)) { //controlla l'esistenza e ritorna l'oggetto
                return PolizzaMapper.daPolizzaAPolizzaDTO(polizzaRepository.findById(id).get());
            } else {
                return null;
            }
        }  catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public PolizzaDTO update(PolizzaDTO dto) {
       try {
           if (polizzaRepository.existsById(dto.getIdPolizza())) { //controlla l'esistenza dell'oggetto
               Polizza polizzaDB = polizzaRepository.findById(dto.getIdPolizza()).get();   //prende il campo nel db per riempire le colonne che non devono essere aggiornate
               if (dto.getIdTipoPolizza().getIdTipoPolizza() == 0) {  //una serie di if che controlla campo per campo
                   dto.setIdTipoPolizza(TipoPolizzaMapper.daTipoPolizzaATipoPolizzaDTO(polizzaDB.getIdTipoPolizza()));
               }
               if (dto.getIdClasse() == 0) {
                   dto.setIdClasse(polizzaDB.getIdClasse());
               }
               if (dto.getIdIntestatario() == 0) {
                   dto.setIdIntestatario(polizzaDB.getIdIntestatario());
               }
               if (dto.getIdStatoPolizza() == 0) {
                   dto.setIdStatoPolizza(polizzaDB.getIdStatoPolizza());
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
               return PolizzaMapper.daPolizzaAPolizzaDTO(polizzaRepository.save(PolizzaMapper.daPolizzaDTOAPolizza(dto))); //viene salvato e il ritornato
           } else {
               return null;
           }
       } catch (Exception e) {
           System.err.println(e.getMessage());
           throw e;
       }
    }

    @Override
    public boolean delete(long id) {
        try {
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
}

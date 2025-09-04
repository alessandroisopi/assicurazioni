package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.entity.Polizza;
import it.onyx.assicurazioni.repository.PolizzaRepository;
import it.onyx.assicurazioni.util.Conversioni;
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

    @Override
    public PolizzaDTO insert(PolizzaDTO dto) {
        Polizza polizza = Conversioni.daPolizzaDTOAPolizza(dto);    //conversione ad entità del dto
        polizza = polizzaRepository.save(polizza);  //effetua il salvataggio sia nel database che nella variabile
        if (polizzaRepository.existsById(dto.getIdPolizza())) { //controllo se andato tutto bene
            return Conversioni.daPolizzaAPolizzaDTO(polizza);
        } else {
            return null;
        }
    }

    @Override
    public List<PolizzaDTO> getAll() {
        List<PolizzaDTO> result = new ArrayList<>();    //istanziata lista per il risultato
        for (Polizza p : polizzaRepository.findAll()) { //itera tutta la tabella e inserisce ogni riga nella lista
            result.add(Conversioni.daPolizzaAPolizzaDTO(p));
        }
        return result;
    }

    @Override
    public PolizzaDTO getById(long id) {
        if (polizzaRepository.existsById(id)) { //controlla l'esistenza e ritorna l'oggetto
            return Conversioni.daPolizzaAPolizzaDTO(polizzaRepository.findById(id).get());
        } else {
            return null;
        }
    }

    @Override
    public PolizzaDTO update(PolizzaDTO dto) {
        if (polizzaRepository.existsById(dto.getIdPolizza())) { //controlla l'esistenza dell'oggetto
            Polizza polizzaDB = polizzaRepository.findById(dto.getIdPolizza()).get();   //prende il campo nel db per riempire le colonne che non devono essere aggiornate
            if (dto.getIdTipoPolizza() == 0) {  //una serie di if che controlla campo per campo
                dto.setIdTipoPolizza(polizzaDB.getIdTipoPolizza());
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
            dto.setCombinato(dto.getIdIntestatario(), dto.getIdTipoPolizza());  //viene reimpostato il campo numPolizza
            return Conversioni.daPolizzaAPolizzaDTO(polizzaRepository.save(Conversioni.daPolizzaDTOAPolizza(dto))); //viene salvato e il ritornato
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        if (polizzaRepository.existsById(id)) { //controlla l'esistenza
            polizzaRepository.deleteById(id);   //lo elimina
            return true;    //torna true
        } else  {   //non esiste torna false
            return false;
        }
    }
}

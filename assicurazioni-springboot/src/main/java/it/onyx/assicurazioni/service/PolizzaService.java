package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.dtoNoEntity.PolizzaInsert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PolizzaService {
    //metodi crud polizza
    PolizzaDTO insert(PolizzaDTO p);    //inserimento
    List<PolizzaDTO> getAll();  //prendi tutti
    PolizzaDTO getById(long idPolizza); //prendi per id
    PolizzaDTO update(PolizzaDTO p);    //aggiorna passando l'oggetto
    boolean delete(long idPolizza, LocalDateTime dtInserimento);  //cancella la polizza

    boolean verificaStatoPolizza(String cd); //controlla se il cd intestatario passato è idoneo alla RCA e controlla se è ancora attiva

    PolizzaDTO insertControllata(PolizzaInsert dto) throws Exception;
}

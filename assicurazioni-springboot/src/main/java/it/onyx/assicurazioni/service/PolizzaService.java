package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.PolizzaDTO;

import java.time.LocalDate;
import java.util.List;

public interface PolizzaService {
    //metodi crud polizza
    PolizzaDTO insert(PolizzaDTO p);    //inserimento
    List<PolizzaDTO> getAll();  //prendi tutti
    PolizzaDTO getById(long idPolizza); //prendi per id
    PolizzaDTO update(PolizzaDTO p);    //aggiorna passando l'oggetto
    boolean delete(long idPolizza, LocalDate dtInserimento);  //cancella la polizza

    boolean verificaStatoPolizza(String cd); //controlla se il cd intestatario passato è idoneo alla RCA e controlla se è ancora attiva
}

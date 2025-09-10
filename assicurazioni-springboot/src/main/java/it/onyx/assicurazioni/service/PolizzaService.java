package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.PolizzaDTO;

import java.time.LocalDate;
import java.util.List;

public interface PolizzaService {
    //metodi crud polizza
    PolizzaDTO insert(PolizzaDTO p);    //inserimento
    List<PolizzaDTO> getAll();  //prendi tutti
    PolizzaDTO getById(long idPolizza, LocalDate dtInserimento); //prendi per id
    PolizzaDTO update(PolizzaDTO p);    //aggiorna passando l'oggetto
    boolean delete(long idPolizza, LocalDate dtInserimento);  //cancella la polizza
}

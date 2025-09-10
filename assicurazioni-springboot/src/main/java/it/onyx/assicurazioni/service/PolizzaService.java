package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.PolizzaDTO;

import java.time.LocalDate;
import java.util.List;

public interface PolizzaService {
    //metodi crud polizza
    public PolizzaDTO insert(PolizzaDTO p);    //inserimento
    public List<PolizzaDTO> getAll();  //prendi tutti
    public PolizzaDTO getById(long idPolizza, LocalDate dtInserimento); //prendi per id
    public PolizzaDTO update(PolizzaDTO p);    //aggiorna passando l'oggetto
    public boolean delete(long idPolizza, LocalDate dtInserimento);  //cancella la polizza
}

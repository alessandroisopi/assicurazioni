package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.PolizzaDTO;

import java.util.List;

public interface PolizzaService {
    //metodi crud polizza
    public PolizzaDTO insert(PolizzaDTO p);    //inserimento
    public List<PolizzaDTO> getAll();  //prendi tutti
    public PolizzaDTO getById(long id); //prendi per id
    public PolizzaDTO update(PolizzaDTO p);    //aggiorna passando l'oggetto
    public boolean delete(long id);  //cancella la polizza
}

package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.TipoPolizzaDTO;

import java.util.List;

public interface TipoPolizzaService {
    List<TipoPolizzaDTO> getAll();   //ottiene tutti i record nel database
    TipoPolizzaDTO getById(long id); //ottiene per id
    TipoPolizzaDTO update(TipoPolizzaDTO dto);   //update del record
}

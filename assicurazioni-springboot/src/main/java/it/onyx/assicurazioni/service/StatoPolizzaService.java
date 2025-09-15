package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.StatoPolizzaDTO;

import java.util.List;

public interface StatoPolizzaService {
    StatoPolizzaDTO insert (StatoPolizzaDTO dto);
    List<StatoPolizzaDTO> getAll();
    StatoPolizzaDTO getById(long id);
    StatoPolizzaDTO update(StatoPolizzaDTO dto);
    boolean delete(long id);
}

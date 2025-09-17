package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.CostoPolizzaDTO;

import java.util.List;

public interface CostoPolizzaService {
    CostoPolizzaDTO insert(CostoPolizzaDTO dto);
    List<CostoPolizzaDTO> getAll();
    CostoPolizzaDTO getById(long id);
    CostoPolizzaDTO update(CostoPolizzaDTO dto);
}

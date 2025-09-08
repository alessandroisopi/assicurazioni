package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.TipoPolizzaDTO;
import it.onyx.assicurazioni.entity.TipoPolizza;

import java.util.List;

public interface TipoPolizzaService {
    public List<TipoPolizzaDTO> getAll();
    public TipoPolizzaDTO getById(long id);
    public TipoPolizzaDTO update(TipoPolizzaDTO dto);
}

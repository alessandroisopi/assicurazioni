package it.onyx.assicurazioni.util;

import it.onyx.assicurazioni.dto.CostoPolizzaDTO;
import it.onyx.assicurazioni.entity.CostoPolizza;

public class CostoPolizzaMapper {

    public static CostoPolizzaDTO toDto(CostoPolizza entity) {
        return new CostoPolizzaDTO(
                TipoPolizzaMapper.toDto(entity.getIdTipoPolizza()),
                entity.getCosto(),
                entity.getId().getDtInizio(),
                entity.getDtFine(),
                entity.getUtenteC()
                );
    }

    public static CostoPolizza toEntity(CostoPolizzaDTO dto) {
        return new CostoPolizza(
                TipoPolizzaMapper.toEntity(dto.getIdTipoPolizza()),
                dto.getCosto(),
                dto.getDtInizio(),
                dto.getDtFine(),
                dto.getUtenteC()
        );
    }
}

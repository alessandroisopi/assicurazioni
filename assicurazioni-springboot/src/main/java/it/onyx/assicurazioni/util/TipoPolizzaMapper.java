package it.onyx.assicurazioni.util;

import it.onyx.assicurazioni.dto.TipoPolizzaDTO;
import it.onyx.assicurazioni.entity.TipoPolizza;

public class TipoPolizzaMapper {

    public static TipoPolizzaDTO toDto(TipoPolizza entity) {
        if (entity == null) {
            return null;
        }
        return new TipoPolizzaDTO(
                entity.getIdTipoPolizza(),
                entity.getDsTipoPolizza(),
                entity.getDtInizio(),
                entity.getDtFine(),
                entity.getUtenteC()
        );
    }
    public static TipoPolizza toEntity(TipoPolizzaDTO dto) {
        if (dto == null) {
            return null;
        }
        return new TipoPolizza(
                dto.getIdTipoPolizza(),
                dto.getDsTipoPolizza(),
                dto.getDtInizio(),
                dto.getDtFine(),
                dto.getUtenteC()
        );
    }
}

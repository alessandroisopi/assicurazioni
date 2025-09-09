package it.onyx.assicurazioni.util;

import it.onyx.assicurazioni.dto.TipoPolizzaDTO;
import it.onyx.assicurazioni.entity.TipoPolizza;

public class TipoPolizzaMapper {

    public static TipoPolizzaDTO daTipoPolizzaATipoPolizzaDTO(TipoPolizza entity) {
        if (entity == null) {
            return null;
        }
        return new TipoPolizzaDTO(
                entity.getIdTipoPolizza(),
                entity.getDsTipoPolizza(),
                entity.getDtInizio(),
                entity.getDtFine()
        );
    }
    public static TipoPolizza daTipoPolizzaDTOATipoPolizza(TipoPolizzaDTO dto) {
        if (dto == null) {
            return null;
        }
        return new TipoPolizza(
                dto.getIdTipoPolizza(),
                dto.getDsTipoPolizza(),
                dto.getDtInizio(),
                dto.getDtFine()
        );
    }
}

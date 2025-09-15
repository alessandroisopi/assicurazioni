package it.onyx.assicurazioni.util;

import it.onyx.assicurazioni.context.UserContext;
import it.onyx.assicurazioni.dto.StatoPolizzaDTO;
import it.onyx.assicurazioni.entity.StatoPolizza;

public class StatoPolizzaMapper {

    public static StatoPolizzaDTO toDto(StatoPolizza entity) {
        if  (entity == null) {
            return null;
        }
        return new StatoPolizzaDTO(
                entity.getIdStatoPolizza(),
                entity.getDsStatoPolizza(),
                entity.getDtInizio(),
                entity.getDtFine()
        );
    }

    public static StatoPolizza toEntity(StatoPolizzaDTO dto) {
        if (dto == null) {
            return null;
        }
        return new StatoPolizza(
                dto.getIdStatoPolizza(),
                dto.getDsStatoPolizza(),
                dto.getDtInizio(),
                dto.getDtFine(),
                UserContext.getUtente().getCF()
        );
    }
}

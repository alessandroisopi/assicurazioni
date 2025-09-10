package it.onyx.assicurazioni.util;

import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.entity.Polizza;

public class PolizzaMapper {
    public static PolizzaDTO daPolizzaAPolizzaDTO(Polizza polizza) {
        if (polizza == null) {
            return null;
        }
        return new PolizzaDTO(
                polizza.getId().getIdPolizza(),
                polizza.getId().getDtInserimento(),
                TipoPolizzaMapper.daTipoPolizzaATipoPolizzaDTO(polizza.getIdTipoPolizza()),
                ClasseMapper.daClasseAClasseDTO(polizza.getIdClasse()),
                polizza.getIdIntestatario(),
                polizza.getIdStatoPolizza(),
                polizza.getDtInizio(),
                polizza.getDtFine(),
                polizza.getNote()
        );
    }

    public static Polizza daPolizzaDTOAPolizza(PolizzaDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Polizza(
                dto.getIdPolizza(),
                dto.getDtInserimento(),
                TipoPolizzaMapper.daTipoPolizzaDTOATipoPolizza(dto.getIdTipoPolizza()),
                ClasseMapper.daClasseDTOAClasse(dto.getIdClasse()),
                dto.getIdIntestatario(),
                dto.getIdStatoPolizza(),
                dto.getNumPolizza(),
                dto.getDtInizio(),
                dto.getDtFine(),
                dto.getNote()
        );
    }
}

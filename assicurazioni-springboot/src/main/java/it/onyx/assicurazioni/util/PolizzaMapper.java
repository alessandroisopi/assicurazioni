package it.onyx.assicurazioni.util;

import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.entity.Polizza;

public class PolizzaMapper {
    public static PolizzaDTO toDto(Polizza polizza) {
        if (polizza == null) {
            return null;
        }
        return new PolizzaDTO(
                polizza.getId().getIdPolizza(),
                polizza.getId().getDtInserimento(),
                TipoPolizzaMapper.toDto(polizza.getIdTipoPolizza()),
                ClasseMapper.toDto(polizza.getIdClasse()),
                polizza.getCdIntestatario(),
                StatoPolizzaMapper.toDto(polizza.getIdStatoPolizza()),
                polizza.getDtInizio(),
                polizza.getDtFine(),
                polizza.getNote(),
                polizza.getUtenteC()
        );
    }

    public static Polizza toEntity(PolizzaDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Polizza(
                dto.getIdPolizza(),
                dto.getDtInserimento(),
                TipoPolizzaMapper.toEntity(dto.getIdTipoPolizza()),
                ClasseMapper.toEntity(dto.getIdClasse()),
                dto.getCdIntestatario(),
                StatoPolizzaMapper.toEntity(dto.getIdStatoPolizza()),
                dto.getNumPolizza(),
                dto.getDtInizio(),
                dto.getDtFine(),
                dto.getNote(),
                dto.getUtenteC()
        );
    }
}

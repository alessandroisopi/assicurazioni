package it.onyx.assicurazioni.util;

import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.entity.Polizza;

public class Conversioni {
    public static PolizzaDTO daPolizzaAPolizzaDTO(Polizza polizza) {
        if (polizza == null) {
            return null;
        }
        return new PolizzaDTO(
                polizza.getIdPolizza(),
                polizza.getIdTipoPolizza(),
                polizza.getIdClasse(),
                polizza.getIdIntestatario(),
                polizza.getIdStatoPolizza(),
                polizza.getNumPolizza(),
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
                dto.getIdTipoPolizza(),
                dto.getIdClasse(),
                dto.getIdIntestatario(),
                dto.getIdStatoPolizza(),
                dto.getNumPolizza(),
                dto.getDtInizio(),
                dto.getDtFine(),
                dto.getNote()
        );
    }
}

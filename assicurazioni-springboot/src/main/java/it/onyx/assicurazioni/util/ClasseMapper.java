package it.onyx.assicurazioni.util;

import it.onyx.assicurazioni.dto.ClasseDTO;
import it.onyx.assicurazioni.entity.Classe;

public class ClasseMapper {
    public static ClasseDTO toDto(Classe entity) {
        return new ClasseDTO(
                entity.getIdClasse(),
                entity.getCdClasse(),
                entity.getDsClasse(),
                entity.getDtInizio(),
                entity.getDtFine()
        );
    }

    public  static Classe toEntity(ClasseDTO dto) {
        return new Classe(
                dto.getIdClasse(),
                dto.getCdClasse(),
                dto.getDsClasse(),
                dto.getDtInizio(),
                dto.getDtFine()
        );
    }
}

package it.onyx.assicurazioni.util;

import it.onyx.assicurazioni.dto.DocumentoPolizzaDTO;
import it.onyx.assicurazioni.entity.DocumentoPolizza;
import it.onyx.assicurazioni.entity.DocumentoPolizzaEmbeddedId;

public class DocumentoPolizzaMapper {
    public DocumentoPolizza toEntity(DocumentoPolizzaDTO dto) {
        return new DocumentoPolizza(
                new DocumentoPolizzaEmbeddedId(dto.getId(), dto.getDtInserimento()),
                dto.getIdPolizza().getIdPolizza(),
                dto.getDoc(),
                dto.getNomeFile(),
                dto.getUtenteC(),
                PolizzaMapper.toEntity(dto.getIdPolizza())
        );
    }
    public DocumentoPolizzaDTO toDto(DocumentoPolizza entity) {
        return new DocumentoPolizzaDTO(
                entity.getId().getId(),
                entity.getId().getDtInserimento(),
                PolizzaMapper.toDto(entity.getPolizza()),
                entity.getDoc(),
                entity.getNomeFile(),
                entity.getUtenteC()
        );
    }
}

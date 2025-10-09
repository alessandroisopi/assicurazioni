package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.DocumentoPolizzaDTO;

public interface DocumentoPolizzaService {
    DocumentoPolizzaDTO insert(DocumentoPolizzaDTO dto) throws Exception;

    DocumentoPolizzaDTO getById(long id) throws Exception;
}

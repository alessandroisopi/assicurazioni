package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.dto.DocumentoPolizzaDTO;
import it.onyx.assicurazioni.entity.DocumentoPolizzaEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoPolizzaRepository extends JpaRepository<DocumentoPolizzaDTO, DocumentoPolizzaEmbeddedId> {
}

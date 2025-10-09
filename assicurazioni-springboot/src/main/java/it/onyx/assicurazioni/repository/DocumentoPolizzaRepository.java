package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.DocumentoPolizza;
import it.onyx.assicurazioni.entity.DocumentoPolizzaEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoPolizzaRepository extends JpaRepository<DocumentoPolizza, DocumentoPolizzaEmbeddedId> {
}

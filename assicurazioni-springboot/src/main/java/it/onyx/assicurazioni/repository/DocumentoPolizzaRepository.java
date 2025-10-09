package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.DocumentoPolizza;
import it.onyx.assicurazioni.entity.DocumentoPolizzaEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoPolizzaRepository extends JpaRepository<DocumentoPolizza, DocumentoPolizzaEmbeddedId> {

    @Query(nativeQuery = true, value = "SELECT * FROM DOCUMENTO_POLIZZA " +
            "WHERE DT_INSERT = (SELECT MAX(DT_INSERT) FROM DOCUMENTO_POLIZZA " +
            "WHERE ID = :id)")
    DocumentoPolizza getById(@Param("id") long id);
}

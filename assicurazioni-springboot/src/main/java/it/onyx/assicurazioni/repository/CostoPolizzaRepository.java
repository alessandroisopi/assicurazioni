package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.CostoPolizza;
import it.onyx.assicurazioni.entity.CostoPolizzaEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoPolizzaRepository extends JpaRepository<CostoPolizza, CostoPolizzaEmbeddedId> {
    @Query(nativeQuery = true, value = "SELECT * FROM COSTO_POLIZZA " +
            "WHERE DT_INIZIO = (SELECT MAX(DT_INIZIO) FROM COSTO_POLIZZA " +
            "WHERE ID_CLASSE = :id)")
    CostoPolizza getById(@Param("id") long id);
}

package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.Polizza;
import it.onyx.assicurazioni.entity.PolizzaEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizzaRepository extends JpaRepository<Polizza, PolizzaEmbeddedId> {
    @Query(nativeQuery = true, value = "SELECT * FROM POLIZZA " +
            "WHERE DT_INSERIMENTO = (SELECT MAX(DT_INSERIMENTO) " +
                                        "FROM POLIZZA " +
                                        "WHERE ID_POLIZZA = :id)")
    Polizza getById(@Param("id") long id);
}

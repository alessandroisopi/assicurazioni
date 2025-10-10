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

    @Query(nativeQuery = true, value = """
            SELECT P.* FROM POLIZZA P, STATO_POLIZZA SP, TIPO_POLIZZA TP WHERE TP.ID_TIPO_POLIZZA = P.ID_TIPO_POLIZZA AND SP.ID_STATO_POLIZZA = P.ID_STATO_POLIZZA AND\s
            P.CD_INTESTATARIO = :id AND SP.ID_STATO_POLIZZA = 1 AND TP.ID_TIPO_POLIZZA = 2 AND P.DT_INSERIMENTO = (SELECT MAX(DT_INSERIMENTO) FROM POLIZZA WHERE CD_INTESTATARIO = :id) AND\s
            SYSDATE BETWEEN P.DT_INIZIO AND P.DT_FINE""")
    Polizza getByCdIntestatario(@Param("id") String id);

    @Query(nativeQuery = true, value = "SELECT * FROM POLIZZA WHERE CD_INTESTATARIO = :cd and DT_INSERIMENTO = (SELECT MAX(DT_INSERIMENTO) FROM POLIZZA WHERE CD_INTESTATARIO = :cd)")
    Polizza getAllByCd(@Param("cd")  String cd);

    @Query(nativeQuery = true, value = "SELECT MAX(ID_POLIZZA) FROM POLIZZA")
    long countMax();
}

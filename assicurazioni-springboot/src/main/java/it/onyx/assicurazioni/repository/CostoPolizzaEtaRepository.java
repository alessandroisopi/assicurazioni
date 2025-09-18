package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.CostoPolizzaEta;
import it.onyx.assicurazioni.entity.CostoPolizzaEtaEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoPolizzaEtaRepository extends JpaRepository<CostoPolizzaEta, CostoPolizzaEtaEmbeddedId> {
}

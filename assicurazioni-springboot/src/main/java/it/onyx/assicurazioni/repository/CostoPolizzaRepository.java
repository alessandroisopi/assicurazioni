package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.CostoPolizza;
import it.onyx.assicurazioni.entity.CostoPolizzaEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoPolizzaRepository extends JpaRepository<CostoPolizza, CostoPolizzaEmbeddedId> {
}

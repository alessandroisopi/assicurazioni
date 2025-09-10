package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.Polizza;
import it.onyx.assicurazioni.entity.PolizzaEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizzaRepository extends JpaRepository<Polizza, PolizzaEmbeddedId> {
}

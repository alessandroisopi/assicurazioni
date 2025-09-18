package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.CostoPolizzaRegione;
import it.onyx.assicurazioni.entity.CostoPolizzaRegioneEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoPolizzaRegioneRepository extends JpaRepository<CostoPolizzaRegione, CostoPolizzaRegioneEmbeddedId> {
}

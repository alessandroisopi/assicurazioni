package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.CostoPolizzaComune;
import it.onyx.assicurazioni.entity.CostoPolizzaComuneEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoPolizzaComuneRepository extends JpaRepository<CostoPolizzaComune, CostoPolizzaComuneEmbeddedId> {
}

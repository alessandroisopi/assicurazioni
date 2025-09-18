package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.CostoPolizzaClasse;
import it.onyx.assicurazioni.entity.CostoPolizzaClasseEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoPolizzaClasseRepository extends JpaRepository<CostoPolizzaClasse, CostoPolizzaClasseEmbeddedId> {
}

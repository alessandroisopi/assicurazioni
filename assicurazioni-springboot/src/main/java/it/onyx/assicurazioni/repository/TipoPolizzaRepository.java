package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.TipoPolizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPolizzaRepository extends JpaRepository<TipoPolizza, Long> {
}

package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.StatoPolizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoPolizzaRepository extends JpaRepository<StatoPolizza, Long> {
}

package it.onyx.assicurazioni.repository;

import it.onyx.assicurazioni.entity.Polizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizzaRepository extends JpaRepository<Polizza, Long> {
}

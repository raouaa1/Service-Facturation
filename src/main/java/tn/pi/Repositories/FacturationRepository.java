package tn.pi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.Entities.Facturation;

import java.util.Optional;

public interface FacturationRepository extends JpaRepository<Facturation, Long>  {
    // Méthode pour trouver une facturation par référence abonné
    Optional<Facturation> findByRefAbonne(String refAbonne);
}

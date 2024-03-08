package BADA_PROJECT.SpringApplication.repository;

import BADA_PROJECT.SpringApplication.entities.Maintenances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenances, Integer> {
}

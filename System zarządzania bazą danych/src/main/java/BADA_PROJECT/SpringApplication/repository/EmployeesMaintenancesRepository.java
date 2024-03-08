package BADA_PROJECT.SpringApplication.repository;

import BADA_PROJECT.SpringApplication.EmbeddedKey.EmployeesMaintenancesKey;
import BADA_PROJECT.SpringApplication.entities.EmployeesMaintenances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeesMaintenancesRepository extends JpaRepository<EmployeesMaintenances, EmployeesMaintenancesKey> {

}

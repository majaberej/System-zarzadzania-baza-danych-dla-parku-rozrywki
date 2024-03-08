package BADA_PROJECT.SpringApplication.repository;

import BADA_PROJECT.SpringApplication.EmbeddedKey.EmployeesAttractionsKey;
import BADA_PROJECT.SpringApplication.entities.EmployeesAttractions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesAttractionsRepository extends JpaRepository<EmployeesAttractions, EmployeesAttractionsKey> {

}

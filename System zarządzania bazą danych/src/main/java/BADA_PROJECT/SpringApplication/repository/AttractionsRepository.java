package BADA_PROJECT.SpringApplication.repository;
import BADA_PROJECT.SpringApplication.entities.Attractions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionsRepository extends JpaRepository<Attractions,Integer> {

}

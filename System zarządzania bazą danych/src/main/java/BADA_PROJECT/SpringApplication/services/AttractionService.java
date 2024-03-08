package BADA_PROJECT.SpringApplication.services;

import BADA_PROJECT.SpringApplication.entities.Attractions;
import BADA_PROJECT.SpringApplication.repository.AttractionsRepository;
import BADA_PROJECT.SpringApplication.repository.MaintenanceRepository;
import BADA_PROJECT.SpringApplication.servicesInterfaces.AttractionServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AttractionService implements AttractionServiceInterface {

    @Autowired
    AttractionsRepository attractionsRepository;
    @Override
    public Attractions getAttraction(int id){
        return attractionsRepository.getReferenceById(id);
    }
    @Override
    public List<Attractions> getAttractions(){
        return attractionsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public  Attractions addAttraction( Attractions attraction){
        return attractionsRepository.saveAndFlush(attraction);
    }
    @Override
    public void deleteAttraction(int id) {
        attractionsRepository.deleteById(id);
    }

    @Override
    public Attractions modifyAttraction(Attractions attraction){
        return  attractionsRepository.save(attraction);
    }
}

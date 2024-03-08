package BADA_PROJECT.SpringApplication.servicesInterfaces;

import BADA_PROJECT.SpringApplication.entities.Attractions;

public interface AttractionServiceInterface {
    Attractions getAttraction(int id);
    Iterable<Attractions> getAttractions();
    Attractions addAttraction(Attractions attraction);
    void deleteAttraction(int id);
    Attractions modifyAttraction(Attractions attraction);
}

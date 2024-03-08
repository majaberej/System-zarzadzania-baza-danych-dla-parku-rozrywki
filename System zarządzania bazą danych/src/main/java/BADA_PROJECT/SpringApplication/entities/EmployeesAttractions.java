package BADA_PROJECT.SpringApplication.entities;

import BADA_PROJECT.SpringApplication.EmbeddedKey.EmployeesAttractionsKey;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pracownicy_atrakcje")
public class EmployeesAttractions {

    @EmbeddedId
    EmployeesAttractionsKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @MapsId("employeeID")
    @JoinColumn(name = "id_pracownika")
    private Employees employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @MapsId("attractionID")
    @JoinColumn(name = "id_atrakcji")
    private Attractions attraction;

}

package BADA_PROJECT.SpringApplication.entities;

import BADA_PROJECT.SpringApplication.EmbeddedKey.EmployeesMaintenancesKey;
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
@Table(name = "pracownicy_konserwacje")
public class EmployeesMaintenances {
    @EmbeddedId
    EmployeesMaintenancesKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @MapsId("employeeID")
    @JoinColumn(name = "id_pracownika")
    private Employees employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @MapsId("maintenanceID")
    @JoinColumn(name = "id_konserwacji")
    private Maintenances maintenance;
}

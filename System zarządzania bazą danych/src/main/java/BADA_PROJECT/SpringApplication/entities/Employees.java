package BADA_PROJECT.SpringApplication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pracownicy")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id_pracownika", nullable = false)
    private int id;
    @Column(name="Imie", nullable = false)
    private String name;
    @Column(name="Nazwisko", nullable = false)
    private String surname;
    @Column(name="Plec", nullable = false)
    private String gender;
    @Column(name = "Pesel")
    private String pesel;
    @Column(name="Stanowisko", nullable = false)
    private String position;

//    @JsonIgnore
//    @JsonBackReference
//    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
//    private List<EmployeesAttractions> employeesAttractions;

    @ManyToMany(mappedBy = "employees", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    private List<Attractions> attractions;

//    @JsonIgnore
//    @JsonBackReference
//    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
//    private List<EmployeesMaintenances> employeesMaintenances;

    @ManyToMany(mappedBy = "employees")
    private List<Maintenances> maintenances;
}

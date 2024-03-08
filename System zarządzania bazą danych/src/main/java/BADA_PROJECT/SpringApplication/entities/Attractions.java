package BADA_PROJECT.SpringApplication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "atrakcje")
public class Attractions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_atrakcji", nullable = false)
    private int id;
    @Column(name = "nazwa_atrakcji", nullable = false)
    private String name;
    @Column(name = "typ_atrakcji", nullable = false)
    private String type;

//    @JsonIgnore
//    @JsonBackReference
//    @OneToMany(mappedBy = "attraction", fetch = FetchType.LAZY)
//    private List<EmployeesAttractions> employeesAttractions;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pracownicy_atrakcje",
            joinColumns = @JoinColumn(name = "id_atrakcji"),
            inverseJoinColumns = @JoinColumn(name = "id_pracownika")
    )
    private List<Employees> employees;

    @JsonIgnore
    @OneToMany(mappedBy = "attraction",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Maintenances> maintenances;

}
package BADA_PROJECT.SpringApplication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "konserwacje")
public class Maintenances {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_konserwacji",nullable = false)
    private int id;
    @Column(name = "data_konserwacji",nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "maintenance", fetch = FetchType.LAZY)
//    private List<EmployeesMaintenances> employeesMaintenances;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "id_atrakcji", nullable = false)
    private Attractions attraction;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pracownicy_konserwacje",
            joinColumns = @JoinColumn(name = "id_konserwacji"),
            inverseJoinColumns = @JoinColumn(name = "id_pracownika")
    )
    private List<Employees> employees;

}

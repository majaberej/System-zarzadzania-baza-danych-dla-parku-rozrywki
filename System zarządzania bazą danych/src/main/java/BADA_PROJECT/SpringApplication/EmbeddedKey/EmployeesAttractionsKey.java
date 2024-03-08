package BADA_PROJECT.SpringApplication.EmbeddedKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeesAttractionsKey implements Serializable{
    @Column(name = "id_pracownika", nullable = false)
    private int employeeID;
    @Column(name = "id_atrakcji", nullable = false)
    private int attractionID;
}

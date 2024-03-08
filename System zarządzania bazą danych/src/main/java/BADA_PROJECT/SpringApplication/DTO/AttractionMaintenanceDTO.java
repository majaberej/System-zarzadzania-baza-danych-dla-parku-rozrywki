package BADA_PROJECT.SpringApplication.DTO;

import BADA_PROJECT.SpringApplication.entities.Attractions;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class AttractionMaintenanceDTO {

    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Attractions attraction;
    private String employees;
}

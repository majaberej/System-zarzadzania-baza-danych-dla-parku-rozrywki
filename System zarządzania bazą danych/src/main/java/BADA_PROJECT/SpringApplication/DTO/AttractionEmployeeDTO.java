package BADA_PROJECT.SpringApplication.DTO;

import BADA_PROJECT.SpringApplication.entities.Employees;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AttractionEmployeeDTO {
    private int id;
    private String name;
    private String type;
    private String employees;
}

package spring.backend.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import spring.backend.entity.MeasureUnit;

@Data
public class CropDTO {
    private int id;
    private String name;
    private MeasureUnit measureUnit;

}

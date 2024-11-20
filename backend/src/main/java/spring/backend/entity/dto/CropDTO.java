package spring.backend.entity.dto;

import lombok.Data;
import spring.backend.entity.MeasureUnit;

@Data
public class CropDTO {
    private int id;
    private String name;
    private MeasureUnit measureUnit;
}

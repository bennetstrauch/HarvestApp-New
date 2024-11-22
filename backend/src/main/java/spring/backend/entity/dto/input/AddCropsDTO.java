package spring.backend.entity.dto.input;

import lombok.Data;

@Data
public class AddCropsDTO {
    private String[] names;
    private String measureUnitName;
}

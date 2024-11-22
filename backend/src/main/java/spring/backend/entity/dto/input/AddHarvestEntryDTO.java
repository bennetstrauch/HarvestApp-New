package spring.backend.entity.dto.input;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddHarvestEntryDTO {

    private LocalDate harvestDate;
    private int cropId;
    private double quantity;
    private int[] harvestedFieldIds;

}

package spring.backend.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HarvestEntryDTO {
    private int id;

    // ### FOR SCALABILITY: Is it good to map these in the backend,
    //     or should we just pass the ids and map them in the frontend?
    //     or should we store the entries like this in the database?
    private LocalDate harvestDate;
    private String cropName;
    private String measureUnitName;
    private double quantity;
    private String[] harvestedFieldNames;

    // #also transfer crop and field ids for filtering

}

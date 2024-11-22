package spring.backend.util;

import org.springframework.stereotype.Component;
import spring.backend.entity.Crop;
import spring.backend.entity.HarvestEntry;
import spring.backend.entity.dto.HarvestEntryDTO;

import java.util.List;

@Component
public class HarvestEntryListMapper {

    public static List<HarvestEntryDTO> mapToDTO(List<HarvestEntry> harvestEntries) {

        // ### FOR SCALABILITY: Is it good to map these in the backend,
        //     (for example the crop to the cropname, etc...)
        //     or should we just pass the ids and map them in the frontend?
        //     or should we store the entries like this in the database?


        List<HarvestEntryDTO> harvestEntriesDTO =
        harvestEntries.stream()
                .map((entry) -> {
            HarvestEntryDTO entryDTO = new HarvestEntryDTO();

            Crop crop = entry.getCrop();

            entryDTO.setId(entry.getId());
            entryDTO.setHarvestDate(entry.getHarvestDate());
            entryDTO.setCropName(crop.getName());
            entryDTO.setMeasureUnitName(crop.getMeasureUnit().getName());
            entryDTO.setQuantity(entry.getQuantity());

            String[] harvestedFieldNames = entry.getHarvestedFields().stream().map((field) -> field.getName()).toArray(String[]::new);
            entryDTO.setHarvestedFieldNames(harvestedFieldNames);


            return entryDTO;
        })
                .toList();


        return harvestEntriesDTO;
    }

}

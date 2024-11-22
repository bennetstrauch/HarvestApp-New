package spring.backend.service.interfaces;

import spring.backend.entity.dto.HarvestEntryDTO;
import spring.backend.entity.dto.input.AddHarvestEntryDTO;
import spring.backend.entity.dto.HarvestFieldDTO;

import java.time.LocalDate;
import java.util.List;

public interface HarvestEntryService {

    List<HarvestEntryDTO> searchEntries(int userId, LocalDate startDate, LocalDate endDate, List<Integer> cropIds, List<Integer> fieldIds);


    int save(int userId, AddHarvestEntryDTO entry);

    List<HarvestFieldDTO> findAllByUserId(int userId);


}

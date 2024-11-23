package spring.backend.service;

import org.springframework.stereotype.Service;
import spring.backend.entity.Crop;
import spring.backend.entity.HarvestEntry;
import spring.backend.entity.HarvestField;
import spring.backend.entity.dto.HarvestEntryDTO;
import spring.backend.entity.dto.HarvestFieldDTO;
import spring.backend.entity.dto.input.AddHarvestEntryDTO;
import spring.backend.entity.dto.input.SearchEntriesDTO;
import spring.backend.repository.CropRepo;
import spring.backend.repository.HarvestEntryRepo;
import spring.backend.repository.HarvestEntrySearchDAO;
import spring.backend.repository.HarvestFieldRepo;
import spring.backend.service.interfaces.HarvestEntryService;
import spring.backend.util.HarvestEntryListMapper;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class HarvestEntryServiceImpl implements HarvestEntryService {


    private final CropRepo cropRepo;
    private final HarvestFieldRepo harvestFieldRepo;
    private final HarvestEntryRepo harvestEntryRepo;
    private final HarvestEntrySearchDAO harvestEntrySearchDAO;

    public HarvestEntryServiceImpl(CropRepo cropRepo, HarvestFieldRepo harvestFieldRepo, HarvestEntryRepo harvestEntryRepo, HarvestEntrySearchDAO harvestEntrySearchDAO) {
        this.cropRepo = cropRepo;
        this.harvestFieldRepo = harvestFieldRepo;
        this.harvestEntryRepo = harvestEntryRepo;
        this.harvestEntrySearchDAO = harvestEntrySearchDAO;
    }

    @Override
    public List<HarvestEntryDTO> searchEntries(int userId, LocalDate startDate, LocalDate endDate, List<Integer> cropIds, List<Integer> fieldIds) {

        SearchEntriesDTO searchEntriesDTO = new SearchEntriesDTO();
        searchEntriesDTO.setStartDate(startDate);
        searchEntriesDTO.setEndDate(endDate);
        searchEntriesDTO.setCropIds(cropIds);
        searchEntriesDTO.setFieldIds(fieldIds);

        List<HarvestEntry> resultEntries = harvestEntrySearchDAO.findAllByCriteria(userId, searchEntriesDTO);

        List<HarvestEntryDTO> resultEntriesDTO = HarvestEntryListMapper.mapToDTO(resultEntries);

        return resultEntriesDTO;
    }

    // # refactor? more elegant
    @Override
    public int save(int userId, AddHarvestEntryDTO entryDTO) {
        int cropId = entryDTO.getCropId();
        Crop crop = cropRepo.findById(cropId).get();

         int[] fieldIds = entryDTO.getHarvestedFieldIds();
         List<HarvestField> fields = Arrays.stream(fieldIds)
                .mapToObj((fieldId) -> harvestFieldRepo.findById(fieldId).get())
                .toList();



        HarvestEntry entry = new HarvestEntry();
        entry.setHarvestDate(entryDTO.getHarvestDate());
        entry.setCrop(crop);
        entry.setQuantity(entryDTO.getQuantity());
        entry.setHarvestFields(fields);

        HarvestEntry savedEntry = harvestEntryRepo.save(entry);

        return savedEntry.getId();
    }

    @Override
    public List<HarvestFieldDTO> findAllByUserId(int userId) {
        return List.of();
    }
}
package spring.backend.service;

import org.springframework.stereotype.Service;
import spring.backend.entity.Crop;
import spring.backend.entity.HarvestField;
import spring.backend.entity.User;
import spring.backend.entity.dto.AddCropsDTO;
import spring.backend.entity.dto.AddHarvestFieldsDTO;
import spring.backend.entity.dto.HarvestFieldDTO;
import spring.backend.repository.HarvestFieldRepo;
import spring.backend.repository.UserRepo;
import spring.backend.util.ListMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class HarvestFieldServiceImpl implements HarvestFieldService {
    private final HarvestFieldRepo harvestFieldRepo;
    private final UserRepo userRepo;
    private final ListMapper listMapper;

    public HarvestFieldServiceImpl(HarvestFieldRepo harvestFieldRepo, UserRepo userRepo, ListMapper listMapper) {
        this.harvestFieldRepo = harvestFieldRepo;
        this.userRepo = userRepo;
        this.listMapper = listMapper;
    }

    @Override
    public List<HarvestFieldDTO> findAllByUserId(int userId) {
        List<HarvestField> allHarvestFields = harvestFieldRepo.findAllByUserId(userId);

        return listMapper.mapList(allHarvestFields, HarvestFieldDTO.class);
    }

    // #verify beforehand if cropname does not yet exist
    @Override
    public List<HarvestField> saveAll(int userId, AddHarvestFieldsDTO toAdd) {
        User user = userRepo.findById(userId).get();

        String[] names = toAdd.getNames();
        // ##

        List<HarvestField> toSave = new ArrayList<>();

        for (String name : names) {
            HarvestField harvestField = new HarvestField();
            harvestField.setUser(user);
            harvestField.setName(name);
            toSave.add(harvestField);
        }

        return (List<HarvestField>) harvestFieldRepo.saveAll(toSave);
    }


}
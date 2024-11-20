package spring.backend.service;

import org.springframework.stereotype.Service;
import spring.backend.entity.Crop;
import spring.backend.entity.MeasureUnit;
import spring.backend.entity.User;
import spring.backend.entity.dto.AddCropsDTO;
import spring.backend.entity.dto.CropDTO;
import spring.backend.repository.CropRepo;
import spring.backend.repository.MeasureUnitRepo;
import spring.backend.repository.UserRepo;
import spring.backend.util.ListMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CropServiceImpl implements CropService {

    private final CropRepo cropRepo;
    private final MeasureUnitRepo measureUnitRepo;
    private final UserRepo userRepo;
    private final ListMapper listMapper;

    public CropServiceImpl(CropRepo cropRepo, MeasureUnitRepo measureUnitRepo, UserRepo userRepo, ListMapper listMapper) {
        this.cropRepo = cropRepo;
        this.measureUnitRepo = measureUnitRepo;
        this.userRepo = userRepo;
        this.listMapper = listMapper;
    }

    //should return CropDto
    @Override
    public List<CropDTO> findAllByUserId(int userId) {
        List<Crop> allCrops = cropRepo.findAllByUserId(userId);

        return listMapper.mapList(allCrops, CropDTO.class);
    }

    // #verify beforehand if cropname does not yet exist
    @Override
    public List<Crop> saveAll(int userId, AddCropsDTO toAdd) {
        User user = userRepo.findById(userId).get();

        String[] names = toAdd.getNames();
        String measureUnitName = toAdd.getMeasureUnitName();
        // ##
        MeasureUnit measureUnit = measureUnitRepo.findByName(measureUnitName)
                .orElseGet(() -> measureUnitRepo.save(new MeasureUnit(measureUnitName)));


        List<Crop> toSave = new ArrayList<>();

        for (String name : names) {
            Crop crop = new Crop();

            crop.setUser(user);
            crop.setName(name);
            crop.setMeasureUnit(measureUnit);
            toSave.add(crop);
        }

        return (List<Crop>) cropRepo.saveAll(toSave);
    }

    @Override
    public Optional<Crop> findById(Integer cropId) {
        return cropRepo.findById(cropId);
    }

    @Override
    public Crop update(Integer cropId, Crop crop) {
        return cropRepo.findById(cropId)
                .map(existingCrop -> {
                    existingCrop.setName(crop.getName()); // Update the name
                    existingCrop.setMeasureUnit(crop.getMeasureUnit()); // Update the MeasureUnit
                    return cropRepo.save(existingCrop); // Save the updated crop
                })
                .orElseThrow(() -> new RuntimeException("Crop not found with ID: " + cropId));
    }

    @Override
    public void deleteById(Integer cropId) {
        if (cropRepo.existsById(cropId)) {
            cropRepo.deleteById(cropId);
        } else {
            throw new RuntimeException("Crop not found with ID: " + cropId);
        }
    }
}
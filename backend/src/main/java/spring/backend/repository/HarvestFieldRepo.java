package spring.backend.repository;

import org.springframework.data.repository.CrudRepository;
import spring.backend.entity.Crop;
import spring.backend.entity.HarvestField;

import java.util.List;

public interface HarvestFieldRepo extends CrudRepository<HarvestField,Integer> {
    List<HarvestField> findAllByUserId(int userId);


    // Add a method to add a list of crops in one batch operation
//    List<Crop> saveAll(Crop[] crops);


}

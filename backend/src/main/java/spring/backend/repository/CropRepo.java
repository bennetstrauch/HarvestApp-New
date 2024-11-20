package spring.backend.repository;

import org.springframework.data.repository.CrudRepository;
import spring.backend.entity.Crop;

import java.util.List;

public interface CropRepo extends CrudRepository<Crop,Integer> {
    List<Crop> findAllByUserId(int userId);


    // Add a method to add a list of crops in one batch operation
//    List<Crop> saveAll(Crop[] crops);


}

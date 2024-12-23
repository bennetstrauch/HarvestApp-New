package spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.backend.entity.Crop;
import spring.backend.entity.HarvestEntry;

import java.util.List;

public interface CropRepo extends CrudRepository<Crop,Integer> {

    List<Crop> findAllByUserId(int userId);

    void deleteAllByUserId(int userId);



    @Query("SELECT c.harvestEntries from Crop c WHERE c.user.id = :userId")
    List<HarvestEntry> findAllHarvestEntriesByUserId(int userId);




}

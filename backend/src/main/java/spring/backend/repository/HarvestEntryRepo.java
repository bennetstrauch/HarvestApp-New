package spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.backend.entity.Crop;
import spring.backend.entity.HarvestEntry;

import java.util.List;

public interface HarvestEntryRepo extends CrudRepository<HarvestEntry,Integer> {



    @Query("SELECT c.harvestEntries from Crop c WHERE c.user.id = :userId")
    List<HarvestEntry> findAllByUserId(int userId);




}

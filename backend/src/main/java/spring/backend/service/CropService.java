package spring.backend.service;

import spring.backend.entity.Crop;
import spring.backend.entity.dto.AddCropsDTO;
import spring.backend.entity.dto.CropDTO;

import java.util.List;
import java.util.Optional;

public interface CropService {

    /**
     * Saves a new crop or updates an existing crop.
     *
     * @param userId
     * @param values the crop to save or update
     * @return the saved crop
     */
    List<Crop> saveAll(int userId, AddCropsDTO values);

    /**
     * Finds a crop by its ID.
     *
     * @param cropId the ID of the crop to find
     * @return an Optional containing the crop if found, or empty if not
     */
    Optional<Crop> findById(Integer cropId);

    /**
     * Retrieves all crops.
     *
     * @return a list of all crops
     */
    List<CropDTO> findAllByUserId(int userId);

    /**
     * Updates an existing crop.
     *
     * @param cropId the ID of the crop to update
     * @param crop the updated crop data
     * @return the updated crop
     */
    Crop update(Integer cropId, Crop crop);

    /**
     * Deletes a crop by its ID.
     *
     * @param cropId the ID of the crop to delete
     */
    void deleteById(Integer cropId);
}

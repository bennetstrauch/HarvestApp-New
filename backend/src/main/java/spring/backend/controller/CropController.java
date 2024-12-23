package spring.backend.controller;

import org.springframework.web.bind.annotation.*;
import spring.backend.entity.Crop;
import spring.backend.entity.dto.input.AddCropsDTO;
import spring.backend.entity.dto.CropDTO;
import spring.backend.service.interfaces.CropService;

import java.util.List;

@CrossOrigin( allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/users/{userId}/crops")
public class CropController {

    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @GetMapping
    public List<CropDTO> getAll(@PathVariable Integer userId) {
        // Log or use userId as needed
        System.out.println("User ID: " + userId);
        return cropService.findAllByUserId(userId);
    }

    @PostMapping
    public void addCrops(@PathVariable Integer userId, @RequestBody AddCropsDTO toAdd) {
        // Log or use userId as needed
        System.out.println("User ID: " + userId + " values " + toAdd);
        cropService.saveAll( userId, toAdd );
    }

    //# impl
//    @DeleteMapping
//    public void delete(@PathVariable Integer userId, @RequestBody Integer[] cropIds) {
//        // Log or use userId as needed
//        System.out.println("User ID: " + userId);
//        cropService.
//    }


    @GetMapping("/{cropId}")
    public Crop getById(@PathVariable Integer userId, @PathVariable Integer cropId) {
        // Log or use userId as needed
        System.out.println("User ID: " + userId);
        return cropService.findById( cropId ).orElseThrow(() -> new RuntimeException("Crop not found"));
    }




}

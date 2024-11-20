package spring.backend.controller;

import org.springframework.web.bind.annotation.*;
import spring.backend.entity.dto.AddHarvestFieldsDTO;
import spring.backend.entity.dto.HarvestFieldDTO;
import spring.backend.service.HarvestFieldService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/users/{userId}/harvest-fields")
public class HarvestFieldController {

    private final HarvestFieldService harvestFieldService;

    public HarvestFieldController(HarvestFieldService harvestFieldService) {
        this.harvestFieldService = harvestFieldService;
    }

    @GetMapping
    public List<HarvestFieldDTO> getAll(@PathVariable Integer userId) {
        // Log or use userId as needed
        System.out.println("User ID: " + userId);
        return harvestFieldService.findAllByUserId(userId);
    }

    @PostMapping
    public void addAll(@PathVariable Integer userId, @RequestBody AddHarvestFieldsDTO toAdd) {
        // Log or use userId as needed
        System.out.println("User ID: " + userId + " values " + toAdd);
        harvestFieldService.saveAll(userId, toAdd);
    }


}

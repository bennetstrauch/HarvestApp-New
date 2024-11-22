package spring.backend.controller;

import org.springframework.web.bind.annotation.*;
import spring.backend.entity.dto.HarvestEntryDTO;
import spring.backend.entity.dto.input.AddHarvestEntryDTO;
import spring.backend.service.interfaces.HarvestEntryService;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/users/{userId}/harvest-entries")
public class HarvestEntryController {

    private final HarvestEntryService harvestEntryService;

    public HarvestEntryController(HarvestEntryService harvestEntryService) {
        this.harvestEntryService = harvestEntryService;
    }

    // change return later on to dot
    @GetMapping("/filter")
    public List<HarvestEntryDTO> searchEntries(
            @PathVariable("userId")Integer userId,
            @RequestParam(value = "startDate", required = true) LocalDate startDate,
//           // # make enddate optional?
            @RequestParam(value = "endDate",required = true) LocalDate endDate,
            @RequestParam(value = "cropIds", required = false) List<Integer> cropIds,
            @RequestParam(value = "fieldIds", required = false) List<Integer> fieldIds
            // # fieldIds
    ) {
        return harvestEntryService.searchEntries(userId, startDate, endDate, cropIds, fieldIds);
    }

    @PostMapping
    public int addEntry(@PathVariable Integer userId, @RequestBody AddHarvestEntryDTO toAdd) {

        System.out.println("User ID: " + userId + " values " + toAdd);

        return harvestEntryService.save(userId, toAdd);
    }

}

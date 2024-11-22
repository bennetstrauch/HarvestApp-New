package spring.backend.service.interfaces;

import spring.backend.entity.HarvestField;
import spring.backend.entity.dto.input.AddHarvestFieldsDTO;
import spring.backend.entity.dto.HarvestFieldDTO;

import java.util.List;

public interface HarvestFieldService {


    List<HarvestField> saveAll(int userId, AddHarvestFieldsDTO values);


    List<HarvestFieldDTO> findAllByUserId(int userId);


}

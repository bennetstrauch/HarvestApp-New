package spring.backend.entity.dto.input;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SearchEntriesDTO   {

    LocalDate startDate;
    LocalDate endDate;

    List<Integer> cropIds;
    List<Integer> fieldIds;
}

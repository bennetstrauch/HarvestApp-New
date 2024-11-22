package spring.backend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.backend.entity.Crop;
import spring.backend.entity.HarvestEntry;
import spring.backend.entity.dto.input.SearchEntriesDTO;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class HarvestEntrySearchDAO {

    private final EntityManager entityManager;


    public List<HarvestEntry> findAllByCriteria(int userId, SearchEntriesDTO searchEntriesDTO){ // You can make a search request object for the input

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HarvestEntry> criteriaQuery = criteriaBuilder.createQuery(HarvestEntry.class);

        // Select * from HarvestEntry
        Root<HarvestEntry> root = criteriaQuery.from(HarvestEntry.class);
        Join<HarvestEntry, Crop> cropJoin = root.join("crop");

        List<Predicate> predicates = new ArrayList<>();
        // Filter by User ID  ###
        Predicate userPredicate = criteriaBuilder.equal(cropJoin.get("user").get("id"), userId);
        predicates.add(userPredicate);

        // Filter by startDate and endDate
        if (searchEntriesDTO.getStartDate() != null) {
            Predicate startDatePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("harvestDate"), searchEntriesDTO.getStartDate());
            predicates.add(startDatePredicate);
        }

        if (searchEntriesDTO.getEndDate() != null) {
            Predicate endDatePredicate = criteriaBuilder.lessThanOrEqualTo(root.get("harvestDate"), searchEntriesDTO.getEndDate());
            predicates.add(endDatePredicate);
        }

        // Filter by cropIds (optional)
        if (searchEntriesDTO.getCropIds() != null && !searchEntriesDTO.getCropIds().isEmpty()) {
            Predicate cropIdsPredicate = cropJoin.get("id").in(searchEntriesDTO.getCropIds());
            predicates.add(cropIdsPredicate);
        }

        // #Filter by field IDs (optional)
//        if (searchEntriesDTO.getFieldIds() != null && !searchEntriesDTO.getFieldIds().isEmpty()) {
//            Join<HarvestEntry, HarvestField> fieldJoin = root.join("harvestedFields");
//            Predicate fieldIdsPredicate = fieldJoin.get("id").in(searchEntriesDTO.getFieldIds());
//            predicates.add(fieldIdsPredicate);

        // Combine predicates
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));


        return entityManager.createQuery(criteriaQuery).getResultList();
        }

}

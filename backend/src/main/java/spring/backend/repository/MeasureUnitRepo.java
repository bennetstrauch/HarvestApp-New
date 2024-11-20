package spring.backend.repository;

import org.springframework.data.repository.CrudRepository;
import spring.backend.entity.MeasureUnit;

import java.util.Optional;

public interface MeasureUnitRepo extends CrudRepository<MeasureUnit, String> {
    Optional<MeasureUnit> findByName(String name);
}

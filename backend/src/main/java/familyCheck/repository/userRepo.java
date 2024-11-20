package familyCheck.repository;

import familyCheck.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface userRepo extends CrudRepository<AppUser,Integer> {
}

package projectTemplate.repository;

import org.springframework.data.repository.CrudRepository;
import projectTemplate.entity.User;

public interface userRepo extends CrudRepository<User,Integer> {
}

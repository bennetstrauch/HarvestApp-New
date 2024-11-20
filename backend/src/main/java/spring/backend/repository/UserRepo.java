package spring.backend.repository;

import org.springframework.data.repository.CrudRepository;
import spring.backend.entity.User;

public interface UserRepo extends CrudRepository<User,Integer> {
}

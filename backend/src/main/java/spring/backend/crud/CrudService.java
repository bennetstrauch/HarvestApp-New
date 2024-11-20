package spring.backend.crud;

import java.util.List;

public interface CrudService<T, ID> {
    List<T> findAllByUserId(ID userId);

}

//package spring.backend.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.transaction.annotation.Transactional;
//import spring.backend.repository.MyCrudRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Transactional
//public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {
//
//    private MyCrudRepository<T, ID> repository;
//
//    public CrudServiceImpl(MyCrudRepository<T, ID> repository) {
//        this.repository = repository;
//    }
//
//
//    @Override
//    public List<T> findAllByUserId(ID userId) {
//        return repository.findAllByUserId(userId);
//    }
//
//
//}
//

//package spring.backend.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import spring.backend.service.CropService;
//import spring.backend.crud.CrudService;
//
//import java.util.List;
//
//public abstract class CrudController<T, ID> {
//
//    private final CrudService<T, ID> service;
//
//    public CrudController(CrudService crudService) {
//        this.service = crudService;
//    }
//
//
//    @GetMapping
//    public List<T> getAll(@PathVariable ID userId) {
//        return service.findAllByUserId(userId);
//    }
//
//
//}
//

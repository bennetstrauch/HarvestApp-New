package projectTemplate.entity;

import jakarta.persistence.*;
import spring.backend.entity.Crop;
import spring.backend.entity.HarvestEntry;
import spring.backend.entity.HarvestField;
import spring.backend.entity.MeasureUnit;

import java.util.List;


@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String email;
    String password;




}

package familyCheck.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class AppUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String email;
    String password;


    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    // shared Task would be manytomany, own task would be onetomany
    @ManyToMany
    private List<Task> tasks;




}

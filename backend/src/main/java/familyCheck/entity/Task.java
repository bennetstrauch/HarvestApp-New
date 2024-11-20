package familyCheck.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Task {

    // should taskId be abs. unique or only for that user?
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int priority;
    private String description;

    @ManyToMany
    private List<AppUser> users;

}

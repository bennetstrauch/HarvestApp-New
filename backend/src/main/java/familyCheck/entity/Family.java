package familyCheck.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Family {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String name;

    @OneToMany(mappedBy = "family")
    private List<AppUser> users;
}

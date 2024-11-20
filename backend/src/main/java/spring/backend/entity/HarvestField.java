package spring.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class HarvestField {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    @Column(unique = true)
    private String name;
}

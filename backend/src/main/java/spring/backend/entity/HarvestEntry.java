package spring.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class HarvestEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate harvestDate;

    @ManyToOne @JoinColumn(name = "crop_id")
    private Crop crop;

    private double quantity;

    @ManyToMany
    private List<HarvestField> harvestFields;



}
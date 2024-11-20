    package spring.backend.entity;

    import jakarta.persistence.*;
    import lombok.Data;

    import java.util.List;


    @Entity @Data
    public class Crop {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne @JoinColumn(name = "user_id")
        private User user;

        @Column(unique = true)
        private String name;

        @ManyToOne @JoinColumn(name = "measure_unit_name")
        private MeasureUnit measureUnit;

        @OneToMany(mappedBy = "crop", fetch = FetchType.LAZY)
        List<HarvestEntry> harvestEntries;



    }



    /* #
    Indexing Foreign Keys:

Add indexes for user_id and measure_unit_id in the database schema for faster lookups and better query performance.
     */

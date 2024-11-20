package spring.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
@Entity
public class MeasureUnit {

    @Id
    private String name;

    private MeasureType type = MeasureType.WEIGHT;

//    no need for being bidirectional
//    @OneToMany(mappedBy = "measureUnit")
//    private List<Crop> crops;


    public MeasureUnit(String name) {
        this.name = name;
    }
}



package bg.softuni.mobilelele.model;

import org.dom4j.rule.Mode;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity{

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ModelEntity> models;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public void setModels(List<ModelEntity> models) {
        this.models = models;
    }
}

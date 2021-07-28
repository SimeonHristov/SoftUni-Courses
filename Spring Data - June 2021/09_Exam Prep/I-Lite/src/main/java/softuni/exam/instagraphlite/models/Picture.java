package softuni.exam.instagraphlite.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{


    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private double size;

    public Picture() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}

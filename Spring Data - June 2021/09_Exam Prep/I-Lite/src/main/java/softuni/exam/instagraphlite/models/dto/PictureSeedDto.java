package softuni.exam.instagraphlite.models.dto;


import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class PictureSeedDto {

    @Expose
    private String path;
    @Expose
    private double size;

    public PictureSeedDto() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Size(min = 500, max = 60000)
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}

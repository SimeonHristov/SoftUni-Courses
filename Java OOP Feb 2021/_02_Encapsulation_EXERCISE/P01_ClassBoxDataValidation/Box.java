package _02_Encapsulation_EXERCISE.P01_ClassBoxDataValidation;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalStateException("Length cannot be zero or negative.");
        } else {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalStateException("Width cannot be zero or negative.");
        } else {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalStateException("Height cannot be zero or negative.");
        } else {
            this.height = height;
        }
    }

    public double calculateSurfaceArea() {
        return this.length * this.width * 2 + this.length* this.height * 2 + this.width * this.height * 2;
    }

    public double calculateLateralSurfaceArea() {
        return this.length* this.height * 2 + this.width * this.height * 2;
    }

    public double calculateVolume() {
        return this.height * this.width * this.length;
    }
}

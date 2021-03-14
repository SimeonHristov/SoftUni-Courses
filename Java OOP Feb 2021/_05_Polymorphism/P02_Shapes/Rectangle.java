package _05_Polymorphism.P02_Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public Double calculateArea() {
        if (getArea() == null) {
            double area = width * height;
            setArea(area);
        }
        return getArea();
    }

    @Override
    public Double calculatePerimeter() {
        if (getPerimeter() == null) {
            double perimeter = width *2 + height * 2;
            setPerimeter(perimeter);
        }
        return getPerimeter();
    }
}

package _05_Polymorphism.P02_Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculateArea() {
        if (getArea() == null) {
            double area = Math.PI * radius * radius;
            setArea(area);
        }
        return getArea();
    }

    @Override
    public Double calculatePerimeter() {
        if (getPerimeter() == null) {
            double perimeter = 2 * Math.PI * radius ;
            setPerimeter(perimeter);
        }
        return getPerimeter();
    }

}

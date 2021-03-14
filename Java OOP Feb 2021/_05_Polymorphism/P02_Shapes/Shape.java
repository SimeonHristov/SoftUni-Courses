package _05_Polymorphism.P02_Shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    protected Double getPerimeter(){
        return  this.perimeter;
    }

    protected void setPerimeter(Double perimeter){
        this.perimeter = perimeter;
    }

    protected Double getArea(){
        return  this.area;
    }

    protected void setArea(Double area){
        this.area = area;
    }


    public abstract Double calculateArea();
    public abstract Double calculatePerimeter();

}

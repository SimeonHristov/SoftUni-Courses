//package _04_Interfaces_And_Abstraction.P01_CarShop;

public interface Car extends Serializable {

    Integer TIRES = 4;

    String getModel();

    Integer getHorsePower();

    String getColor();

    String getCountryProduced();

}

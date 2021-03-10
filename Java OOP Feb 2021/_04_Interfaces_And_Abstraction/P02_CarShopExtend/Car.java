package _04_Interfaces_And_Abstraction.P02_CarShopExtend;//package _04_Interfaces_And_Abstraction.P01_CarShop;

import java.io.Serializable;

public
interface Car extends Serializable{
    int TIRES = 4;

    String getModel ();

    String getColor ();

    Integer getHorsePower ();

    String countryProduced ();
}
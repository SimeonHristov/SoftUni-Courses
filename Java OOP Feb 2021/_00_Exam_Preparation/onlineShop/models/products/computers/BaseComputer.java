package onlineShop.models.products.computers;

import onlineShop.models.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer{

    private List<Component> components ;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    //TODO override toSTring
    //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id})"
    //" Components ({components count}):"
    //"  {component one}"
    //"  {component two}"
    //"  {component n}"
    //" Peripherals ({peripherals count}); Average Overall Performance ({average overall performance peripherals}):"
    //"  {peripheral one}"
    //"  {peripheral two}"
    //"  {peripheral n}"


}

package onlineShop.models.products.peripherals;

import onlineShop.models.BaseProduct;

public abstract class BasePeripheral extends BaseProduct implements  Peripheral{

    private String connectionType;

    protected BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    //TODO override toString
    //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id}) Connection Type: {connection type}"

    @Override
    public String getConnectionType() {
        return connectionType;
    }

    private void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }
}

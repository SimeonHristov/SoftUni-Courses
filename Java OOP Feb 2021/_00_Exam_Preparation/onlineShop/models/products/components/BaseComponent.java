package onlineShop.models.products.components;

import onlineShop.models.BaseProduct;

public abstract class BaseComponent extends BaseProduct implements Component {

    private int generation;

    protected BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        setGeneration(generation);
    }

    //TODO Override ToString
    //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id}) Generation: {generation}"

    @Override
    public int getGeneration() {
        return generation;
    }

    private void setGeneration(int generation) {
        this.generation = generation;
    }
}

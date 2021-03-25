package onlineShop.models;

import onlineShop.models.products.Product;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseProduct implements Product {
    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;



    protected BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        setId(id);
        setManufacturer(manufacturer);
        setModel(model);
        setPrice(price);
        setOverallPerformance(overallPerformance);
    }

    //TODO - Override ToSTring
    //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id})"

    public int getId() {
        return id;
    }

    private void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException (INVALID_PRODUCT_ID);
        }
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    private void setManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.trim().isEmpty()){
            throw new IllegalArgumentException (INVALID_MANUFACTURER);
        }
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty()){
            throw new IllegalArgumentException (INVALID_MODEL);
        }
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException (INVALID_PRICE);
        }
        this.price = price;
    }

    public double getOverallPerformance() {
        return getOverallPerformance();
    }

    private void setOverallPerformance(double overallPerformance) {
        if (overallPerformance <= 0) {
            throw new IllegalArgumentException (INVALID_OVERALL_PERFORMANCE);
        }
        this.overallPerformance = overallPerformance;
    }
}

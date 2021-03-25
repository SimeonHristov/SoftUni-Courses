package onlineShop.models.products;

import onlineShop.models.BaseProduct;

public interface Product {

    int getId();

    String getManufacturer();

    String getModel();

    double getPrice();

    double getOverallPerformance();
}

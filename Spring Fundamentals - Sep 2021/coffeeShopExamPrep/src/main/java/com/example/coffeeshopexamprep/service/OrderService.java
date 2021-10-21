package com.example.coffeeshopexamprep.service;

import com.example.coffeeshopexamprep.model.serviceModels.OrderServiceModel;
import com.example.coffeeshopexamprep.model.viewModels.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllByOrderByPriceDesc();

    void readyOrder(Long id);
}

package com.gmail.vladyslavnicko.beerstore.services.order;

import com.gmail.vladyslavnicko.beerstore.dto.OrderDTO;

public interface OrdersServices {
    boolean addOrder(OrderDTO orderDto);
    void deleteUser(long orderId);
}

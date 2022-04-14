package com.gmail.vladyslavnicko.beerstore.services.order;

import com.gmail.vladyslavnicko.beerstore.dto.OrderDTO;
import com.gmail.vladyslavnicko.beerstore.model.Order;
import com.gmail.vladyslavnicko.beerstore.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import static com.gmail.vladyslavnicko.beerstore.model.OrderStatus.NEW;

@Service
public class OrdersServiceImpl implements OrdersServices{

    private final OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public boolean addOrder(OrderDTO orderDto) {
        Order order = Order.fromDTO(orderDto);
        order.setStatus(NEW);
        ordersRepository.save(order);
        return true;
    }

    @Override
    public void deleteUser(long orderId) {
        ordersRepository.deleteById(orderId);
    }
}

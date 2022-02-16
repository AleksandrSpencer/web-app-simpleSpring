package com.spencer.webappsimpleSpring.services;

import com.spencer.webappsimpleSpring.entities.Order;
import com.spencer.webappsimpleSpring.entities.OrderItem;
import com.spencer.webappsimpleSpring.entities.User;
import com.spencer.webappsimpleSpring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrderFromItems(User user, List<OrderItem> items) {
        Order order = new Order();
        order.setItems(new ArrayList<>());
        order.setUser(user);
        items.stream().forEach(item -> {
            order.getItems().add(item);
            item.setOrder(order);
        });
        items.clear();
        return orderRepository.save(order);
    }
}

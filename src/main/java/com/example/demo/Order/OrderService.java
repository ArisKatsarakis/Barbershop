package com.example.demo.Order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return  orderRepository.findAll();
    }

    public void addNewOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }
}

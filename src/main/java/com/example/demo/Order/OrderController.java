package com.example.demo.Order;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
            return orderService.getOrders();
    }

    @PostMapping("/orders")
    public void createOrder(@RequestBody Order newOrder) {
            orderService.addNewOrder(newOrder);
    }

}

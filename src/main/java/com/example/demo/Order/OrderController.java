package com.example.demo.Order;

import com.example.demo.Product.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    @CrossOrigin
    public List<SalesOrder> getOrders() {
            return orderService.getOrders();
    }

    @PostMapping("/orders")
    @CrossOrigin
    public void createOrder(@RequestBody SalesOrder newSalesOrder) {
            orderService.addNewOrder(newSalesOrder);
    }

    @GetMapping("/orders/{id}")
    @CrossOrigin
    public Optional<SalesOrder> getOrderById(@PathVariable("id") long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders/{id}")
    @CrossOrigin
    public Optional<SalesOrder> addProductsToOrderById(@PathVariable("id") long id, @RequestBody Set<Product> productSet) {
        return orderService.addProductsToOrder(id, productSet);
    }


}

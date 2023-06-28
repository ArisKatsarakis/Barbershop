package com.example.demo.Order;

import com.example.demo.Product.Product;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<SalesOrder> getOrders() {
        return  orderRepository.findAll();
    }

    public void addNewOrder(SalesOrder newSalesOrder) {
        orderRepository.save(newSalesOrder);
    }

    public Optional<SalesOrder> getOrderById(long id) {
        return orderRepository.findById(id);
    }

    public Optional<SalesOrder> addProductsToOrder(long id, Set<Product> productSet) {
        Optional<SalesOrder> foundOrder = orderRepository.findById(id);
        foundOrder.ifPresent(
                salesOrder -> {
                    Set<Product> allProducts = new HashSet<Product>();
                    allProducts.addAll(salesOrder.getProducts());
                    allProducts.addAll(productSet);
                    salesOrder.setProducts(allProducts);
                    salesOrder.setTotalCost(0);
                    salesOrder.getProducts().stream().forEach(
                            product -> salesOrder.setTotalCost(salesOrder.getTotalCost() + product.getCost())
                    );
                    orderRepository.save(salesOrder);
                }
        );
        return foundOrder;
    }

    public List<SalesOrder> getOrderByCustomerId(long id) {
        return orderRepository.findByCustomerId(id);
    }
}

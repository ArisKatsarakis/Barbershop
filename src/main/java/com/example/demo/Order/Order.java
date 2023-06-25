package com.example.demo.Order;

import com.example.demo.Product.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ORDER")

public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column(name ="order_id")
    private  long id;
    private long customerId;

    @OneToMany(mappedBy = "order")
    private Set<Product> Products;
    private float totalCost;

    public Order() {
    }

    public Order(long customer_id) {
        this.customerId = customer_id;
        this.totalCost = 0;

    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer_id=" + customerId +
                ", Products=" + Products +
                ", totalCost=" + totalCost +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomer_id() {
        return customerId;
    }

    public void setCustomer_id(long customer_id) {
        this.customerId = customer_id;
    }

    public Set<Product> getProducts() {
        return Products;
    }

    public void setProducts(Set<Product> products) {
        Products = products;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}

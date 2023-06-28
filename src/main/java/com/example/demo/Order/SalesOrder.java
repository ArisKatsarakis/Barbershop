package com.example.demo.Order;

import com.example.demo.Product.Product;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class SalesOrder {
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

    @ManyToMany
    @JoinTable(
            name ="orders_purchased",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_ID")
    )
    private Set<Product> Products;

    private float totalCost;

    public SalesOrder() {
    }

    public SalesOrder(long customer_id, Set<Product> products) {
        Logger newlogger = LoggerFactory.getLogger(SalesOrder.class);
        newlogger.info(products.toString());

        this.customerId = customer_id;
        this.totalCost = 0;

    }

    @Override
    public String toString() {
        return "SalesOrder{" +
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

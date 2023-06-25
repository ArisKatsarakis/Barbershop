package com.example.demo.Product;

import com.example.demo.Order.Order;

import javax.persistence.*;

@Table(name = "PRODUCTS")
@Entity
public class Product {
    @Id
    @SequenceGenerator(
        name= "product_sequence",
        sequenceName = "product_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name="product_ID")
    private long id;
    private String name;
    private Float cost;
    private String type;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;
    public Product() {}

    public Product(String name, Float cost, String type) {
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", type='" + type + '\'' +
                '}';
    }
}

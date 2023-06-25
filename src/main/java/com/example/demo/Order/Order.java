package com.example.demo.Order;

import com.example.demo.Product.Product;

import javax.persistence.*;
import java.util.Set;

@Table(name = "ORDER")
@Entity
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
    private long customer_id;

    @OneToMany(mappedBy = "order")
    private Set<Product> Products;



}

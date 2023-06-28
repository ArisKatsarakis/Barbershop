package com.example.demo.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<SalesOrder,Long> {
    Optional<SalesOrder> findById(Long id );

}

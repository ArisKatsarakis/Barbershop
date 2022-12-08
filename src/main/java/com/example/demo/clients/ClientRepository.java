package com.example.demo.clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Clients,Long> {
    @Query("select  s from Clients s where s.id = ?1")
    public Optional<Clients> findById(Long id);
}

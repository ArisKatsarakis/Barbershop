package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BarbershopUserRepository extends JpaRepository<BarbershopUser, Long> {

    List<BarbershopUser> findByUsername(String username);
}

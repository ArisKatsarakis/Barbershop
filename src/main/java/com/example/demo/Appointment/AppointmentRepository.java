package com.example.demo.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
    @Query("SELECT s FROM Appointment  s WHERE s.Username = ?1")
    Optional<Appointment> findAppointmentByUsername(String username);
}

package com.example.demo.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
//    Optional<Appointment> findByDate(LocalDate date);
        @Query("SELECT s FROM Appointment  s WHERE s.Username = ?1")
        List<Appointment> findByUsername(String Username);



        @Query("SELECT s FROM Appointment s WHERE s.date = ?1")
        List<Appointment> findbyDate(LocalDate newDate);
//    List<Appointment> findAppointmentByUsername(String username);
}
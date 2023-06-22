package com.example.demo.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

//    @Query("SELECT app.time,app.type, app.customerId, cli.firstName as Customer  " +
//            "FROM Appointment  app " +
//            "left join Client  cli on cli.id = app.customerId  " +
//            "Where app.barberId= ?1 ")
    List<Appointment> findByBarberId(Long barberId);
}
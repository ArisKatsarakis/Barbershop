package com.example.demo.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
//    Optional<Appointment> findByDate(LocalDate date);
        @Query("SELECT s FROM Appointment  s WHERE s.Username = ?1")
        List<Appointment> findByUsername(String Username);



        @Query("SELECT s FROM Appointment s WHERE s.date = ?1")
        List<Appointment> findbyDate(LocalDate newDate);

        @Modifying
        @Query("update Appointment s set s.Username = ?2 , s.date=?3, s.time=?4, s.type=?5 where s.id = ?1")
        void updateAppointmentById(long appointmentId, String username, LocalDate date, LocalTime time, String type);

        @Query("SELECT s FROM Appointment  s where s.BarberId = ?1")
         List<Appointment> getAppointmentByBarber(long barberID);


}
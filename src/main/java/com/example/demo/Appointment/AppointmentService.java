package com.example.demo.Appointment;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentService {

    public static  List<Appointment> getAppointments(){
        return List.of(
                new Appointment(1l,1l, LocalDate.of(2022,6,10), LocalTime.of(9,30),"Mousia","Antonis" )
        );
    }
}

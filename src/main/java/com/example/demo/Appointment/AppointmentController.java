package com.example.demo.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/appointment")
public class AppointmentController {
    private final AppointmentService appService;

    @Autowired
    public AppointmentController(AppointmentService appSerivce){
        this.appService = appSerivce;
    }
    @GetMapping
    public List<Appointment> getStudents() {
        return AppointmentService.getAppointments();
    }

}

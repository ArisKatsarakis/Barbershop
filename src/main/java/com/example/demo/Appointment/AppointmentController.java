package com.example.demo.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return appService.getAppointments();
    }

    @PostMapping
    public void makeNewAppointment(@RequestBody Appointment appointment){
        appService.addNewAppointment(appointment);

    }

    @DeleteMapping
    public void deleteAppointment(@RequestBody Appointment app){
        appService.deleteAppointment(app);
    }

}
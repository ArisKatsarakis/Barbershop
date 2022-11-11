package com.example.demo.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @GetMapping( path = "{username}")
    public List<Appointment> getAppointmentByUsername(@PathVariable("username") String username){
        System.out.println(username);
        return appService.getAppointByUsername(username);
    }

    @CrossOrigin
    @PostMapping(path = "/date")
    public List<Appointment> getAppointmentByDate(@RequestBody Appointment appointment){

        return appService.getAppointmentBydate(appointment.getDate());
    }
}
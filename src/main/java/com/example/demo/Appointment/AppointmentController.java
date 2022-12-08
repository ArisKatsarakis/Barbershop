package com.example.demo.Appointment;

import com.example.demo.barbers.Barber;
import com.example.demo.barbers.BarberService;
import com.example.demo.clients.ClientRepository;
import com.example.demo.clients.ClientService;
import com.example.demo.clients.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class AppointmentController {
    private final AppointmentService appService;
    private final BarberService barberService;

    private final ClientService clientService;
    @Autowired
    public AppointmentController(AppointmentService appSerivce, BarberService barberService, ClientService clientService){
        this.barberService = barberService;
        this.appService = appSerivce;
        this.clientService = clientService;
    }
    @GetMapping
    public List<Appointment> getStudents() {
        return appService.getAppointments();
    }

    @PostMapping("/appointment")
    public void makeNewAppointment(@RequestBody Appointment appointment){
        appService.addNewAppointment(appointment);

    }

    @PutMapping("/appointment/{id}")
    public Optional<Appointment> updateAppointment(@PathVariable("id") long appointmentId , @RequestBody Appointment appointment){
        return appService.updateAppointment(appointmentId,appointment);
    }

    @GetMapping( path = "appointment/{username}")
    public List<Appointment> getAppointmentByUsername(@PathVariable("username") String username){
        System.out.println(username);
        return appService.getAppointByUsername(username);
    }

    @CrossOrigin
    @PostMapping(path = "appointment/date")
    public List<Appointment> getAppointmentByDate(@RequestBody Appointment appointment){
        return appService.getAppointmentBydate(appointment.getDate());
    }

    @CrossOrigin
    @GetMapping("/barber")
    public List<Barber> getBarbers(){
        return barberService.getBarbers();
    }

    @CrossOrigin
    @PostMapping("/barber")
    public void newBarber(@RequestBody Barber barber){
        barberService.addNewBarber(barber);
    }

    @DeleteMapping("appointment/delete/{id}")
    public Optional<Appointment> deletAppointmentById(@PathVariable("id") long appointmentId){
        return appService.deleteAppoitnmentById(appointmentId);
    }

    @PostMapping("client/add")
    public Clients addNewClient(@RequestBody Clients client){
        return clientService.addNewClient(client);
    }

    @GetMapping("client")
    public List<Clients> getAllClients(){
        return clientService.getAllClients();
    }

    @DeleteMapping("client/delete/{id}")
    public Optional<Clients> deleteClient(@PathVariable("id") Long id) {
        return clientService.deleteClient(id);
    }
}
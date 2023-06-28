package com.example.demo.Appointment;

import com.example.demo.client.Client;
import com.example.demo.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping(path = "api/v1")
public class AppointmentController {
    private final AppointmentService appService;
    @Autowired
    public AppointmentController(AppointmentService appSerivce){
        this.appService = appSerivce;
    }
    @GetMapping("/appointment")
    public List<Appointment> getStudents() {
        return appService.getAppointments();
    }

    @PostMapping("/appointment")
    @CrossOrigin
    public void makeNewAppointment(@RequestBody Appointment appointment){
        appService.addNewAppointment(appointment);

    }

    @CrossOrigin
    @GetMapping("/appointment/barbers/{id}")
    public ResponseEntity<List<Object>> getAppointsByBarbersID(@PathVariable("id") Long barberId) {
        List<Object> listOfAppointments = new ArrayList<>();

        List<Appointment> appointmentsFetched = appService.getAppointmentsByBarberId(barberId);
        appointmentsFetched.stream().forEach(
                appointment -> {
                    Map<String,Object> result = new HashMap<String, Object>();
                    Optional<Client> client = ClientService.getClientById(appointment.getCustomerId());
                    AtomicReference<String> clientsName = new AtomicReference<>("");
                    client.ifPresent(cli -> clientsName.set(cli.getFirstName() + " " + cli.getLastName()));
                    result.put("time",appointment.getTime());
                    result.put("type",appointment.getType());
                    result.put("customer",clientsName);
                    result.put("barberId",appointment.getBarberId());
                    listOfAppointments.add(result);
                }
        );

        return ResponseEntity.ok(listOfAppointments);

    }


}
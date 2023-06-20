package com.example.demo.barbers;

import com.example.demo.Appointment.Appointment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class BarberControler {

    private BarberService barberService;

    public BarberControler(BarberService barberService) {
        this.barberService = barberService;
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



}

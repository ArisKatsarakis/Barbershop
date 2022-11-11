package com.example.demo.barbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {
    private final BarberRepository barberRepository;

    @Autowired
    public BarberService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;

    }

    public List<Barber> getBarbers(){
        return barberRepository.findAll();
    }
    /*
    * Missing Error Checking for Already Existing Barber
    * @TODO
    * */
    public void addNewBarber(Barber barber) {
        barberRepository.save(barber);
    }
}
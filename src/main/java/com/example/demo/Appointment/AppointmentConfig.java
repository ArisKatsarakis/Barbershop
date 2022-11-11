package com.example.demo.Appointment;

import com.example.demo.barbers.Barber;
import com.example.demo.barbers.BarberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class AppointmentConfig {
    @Bean
    CommandLineRunner commandLineRunner(AppointmentRepository repository, BarberRepository brepository){
        return args -> {
           Appointment one = new Appointment(1l,
                   1l, LocalDate.of(2022,11,
                   11), LocalTime.of(9,
                   30),
                   "Mousia",
                   "Antonis" );
           Appointment two =  new Appointment(2l,1l, LocalDate.of(2022,11,10), LocalTime.of(9,30),"malli","Kostas" );
            Appointment three =  new Appointment(3l,1l, LocalDate.of(2022,11,10), LocalTime.of(9,30),"malli","Kostas" );

            repository.saveAll(
                    List.of(one,two,three)
            );
            Barber onew = new Barber(1l, "Mixalis" );
            brepository.save(onew);
        };

    }
}

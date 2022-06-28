package com.example.demo.Appointment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class AppointmentConfig {
    @Bean
    CommandLineRunner commandLineRunner(AppointmentRepository repository){
        return args -> {
           Appointment one = new Appointment(1l,
                   1l, LocalDate.of(2022,6,
                   10), LocalTime.of(9,
                   30),
                   "Mousia",
                   "Antonis" );
           Appointment two =  new Appointment(2l,1l, LocalDate.of(2022,6,10), LocalTime.of(9,30),"malli","Kostas" );

            repository.saveAll(
                    List.of(one,two)
            );
        };

    }
}

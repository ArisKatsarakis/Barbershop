package com.example.demo;

import com.example.demo.Appointment.Appointment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
@RestController
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @GetMapping
    public List<Appointment> Hello(){
        return List.of(
          new Appointment(1l,1l, LocalDate.of(2022,6,10), LocalTime.of(9,30),"Mousia","Antonis" )
        );
    }


}

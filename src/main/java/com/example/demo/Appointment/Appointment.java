package com.example.demo.Appointment;

import com.example.demo.barbers.Barber;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table

//Create state taken , open;

public class Appointment {
    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )
    private Long id;

    private Long barberId;
    private LocalDate date;
    private LocalTime time;
    private String type;
    private Long customerId;

    public Appointment() {
    }

    public Appointment(Long barberId, LocalDate date, LocalTime time, String type, Long customerId) {
        barberId = barberId;
        this.date = date;
        this.time = time;
        this.type = type;
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long BarberId) {
        barberId = BarberId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", Barber_id=" +  barberId +
                ", date=" + date +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", Customer_id=" + customerId +
                '}';
    }
}

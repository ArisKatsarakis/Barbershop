package com.example.demo.Appointment;

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
    private Long Userid;
    private LocalDate date;
    private LocalTime time;
    private String type;
    private String Username;

    public Appointment() {
    }

    public Appointment(Long id, Long userid, LocalDate date, LocalTime time, String type, String username) {
        this.id = id;
        Userid = userid;
        this.date = date;
        this.time = time;
        this.type = type;
        Username = username;
    }

    public Appointment(Long userid, LocalDate date, LocalTime time, String type, String username) {
        Userid = userid;
        this.date = date;
        this.time = time;
        this.type = type;
        Username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return Userid;
    }

    public void setUserid(Long userid) {
        Userid = userid;
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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", Userid=" + Userid +
                ", date=" + date +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", Username='" + Username + '\'' +
                '}';
    }
}

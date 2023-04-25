package com.example.demo.barbers;

import com.example.demo.Appointment.Appointment;

import javax.persistence.*;

import java.lang.reflect.Array;
import java.util.List;
@Entity
@Table

public class Barber {
    @Id
    @SequenceGenerator(
            name = "barber_sequence",
            sequenceName = "barber_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "barber_sequence"
    )
    private long id;
    private String name;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Barber() {
    }

    public Barber(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Barber(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Barber{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}

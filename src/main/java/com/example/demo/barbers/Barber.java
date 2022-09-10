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
    private long id;
    private long name;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
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

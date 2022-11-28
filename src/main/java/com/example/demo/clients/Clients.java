package com.example.demo.clients;

import javax.persistence.*;

@Entity
@Table
public class Clients {
    @Id
    @SequenceGenerator(
            name="client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private long id;
    private String Name;
    private String SirName;
    private String Number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSirName() {
        return SirName;
    }

    public void setSirName(String sirName) {
        SirName = sirName;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public Clients(String name, String sirName, String number) {
        Name = name;
        SirName = sirName;
        Number = number;
    }

    public Clients() {
    }

    public Clients(long id, String name, String sirName, String number) {
        this.id = id;
        Name = name;
        SirName = sirName;
        Number = number;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", SirName='" + SirName + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }
}

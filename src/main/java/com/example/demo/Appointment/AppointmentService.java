package com.example.demo.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public  List<Appointment> getAppointments(){
        return appointmentRepository.findAll();
    }

    public void addNewAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);

    }
    public List<Appointment> getAppointByUsername(String username){
       return appointmentRepository.findByUsername(username);
    }

    public List<Appointment> getAppointmentBydate(LocalDate newDate) {
        return appointmentRepository.findbyDate(newDate);
    }
}

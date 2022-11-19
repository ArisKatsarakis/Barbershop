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

    public Optional<Appointment> updateAppointment(long appointmentId, Appointment updatedAppointment) {
        return appointmentRepository.findById(appointmentId).map(
                appointment1 -> {
                    if(updatedAppointment.getDate() != null){
                        appointment1.setDate(updatedAppointment.getDate());
                    }
                    if(updatedAppointment.getUsername() != null){
                        appointment1.setUsername(updatedAppointment.getUsername());
                    }
                    if(updatedAppointment.getTime() != null){
                        appointment1.setTime(updatedAppointment.getTime());
                    }
                    if(updatedAppointment.getType() != null){
                        appointment1.setType(updatedAppointment.getType());
                    }
                    return appointmentRepository.save(appointment1);
                }
        );
    }
}

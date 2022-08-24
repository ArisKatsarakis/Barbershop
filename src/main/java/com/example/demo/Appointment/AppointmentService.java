package com.example.demo.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //Set option to find Appointments by username and email
        // So that we configure the date that the user wants the appointment
        // This is a basic implementantion
        Optional<Appointment> AppointmentByUsername =
                appointmentRepository.findAppointmentByUsername(appointment.getUsername());

        if (AppointmentByUsername.isPresent()){
            throw  new IllegalStateException("Appointment Taken");

        }
        appointmentRepository.save(appointment);

    }
    public void deleteAppointment(Appointment appointment){
        Optional<Appointment> appfind = appointmentRepository.findAppointmentByUsername(appointment.getUsername());
        if(appfind.isPresent()){
            throw new IllegalStateException("Appointment Not Found ! ");
        }
        appointmentRepository.delete(appointment);
    }
}

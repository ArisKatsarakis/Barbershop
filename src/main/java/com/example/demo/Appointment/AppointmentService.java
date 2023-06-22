package com.example.demo.Appointment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private    Logger serviceLogger;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
        this.serviceLogger = LoggerFactory.getLogger(AppointmentService.class);
    }

    public  List<Appointment> getAppointments(){
        return appointmentRepository.findAll();
    }

    public void addNewAppointment(Appointment appointment) {
        serviceLogger.info(appointment.toString());
        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByBarberId(Long barberId) {
        serviceLogger.info("We are fetching appointmets for Barber with id" + barberId);
       return  appointmentRepository.findByBarberId(barberId);

    }
}

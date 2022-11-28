package com.example.demo.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Clients addNewClient(Clients client){
       return clientRepository.save(client);
    }

    public List<Clients> getAllClients() {
       return  clientRepository.findAll();
    }
}

package com.example.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ClientService {

    private ClientRepository clientRepository;
    private static final Logger serviceLogger = LoggerFactory.getLogger(ClientService.class);

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void createClient(Client newClient) {
        serviceLogger.info(newClient.toString());
        clientRepository.save(newClient);
    }

    public Optional<Client> getClientById(Long clientsId) {
        return clientRepository.findById(clientsId);
    }
}

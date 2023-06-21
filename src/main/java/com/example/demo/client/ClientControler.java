package com.example.demo.client;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ClientControler {

    private ClientService clientService;


    public ClientControler(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @PostMapping("/clients")
    public void createClient(@RequestBody Client newClient) {
         clientService.createClient(newClient);
    }

    @GetMapping("/clients/{id}")
    public Optional<Client> getClientsById(@PathVariable("id") Long clientsId) {
        return clientService.getClientById(clientsId);
    }

}

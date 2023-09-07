package com.task.ClientsInfo.controller;

import com.task.ClientsInfo.dto.ClientDTO;
import com.task.ClientsInfo.entity.Client;
import com.task.ClientsInfo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ClientsController {

    @Autowired
    private ClientService service;

    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) {
        return service.createClient(client);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable long id, @RequestBody Client client) {
        return service.updateClient(id, client);
    }
    @GetMapping("/clients")
    public List<ClientDTO> getAllClients() {
        return service.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClientById(@PathVariable long id) {
        return service.getClientById(id);
    }
    @GetMapping("/clients/{id}/contacts")
    public Client getClientContactsById(@PathVariable long id) {
        return service.getClientContactsById(id);
    }

    @GetMapping(value = "/clients/{id}/contacts", params = "type")
    public Set<String> getClientContactsByTypeById(@PathVariable long id, @RequestParam(name = "type") String type) {
        return service.getClientContactsByTypeById(id, type);
    }
}

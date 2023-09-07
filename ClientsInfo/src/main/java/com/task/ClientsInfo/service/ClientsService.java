package com.task.ClientsInfo.service;

import com.task.ClientsInfo.dto.ClientDTO;
import com.task.ClientsInfo.entity.Client;
import com.task.ClientsInfo.exceptions.ClientNotFoundException;
import com.task.ClientsInfo.repository.ClientsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository repository;
    @Autowired
    private ModelMapper mapper;

    public List<ClientDTO> getAllClients() {
        return repository.findAll().stream().map(this::convertToDTO).toList();
    }

    public ClientDTO getClientById(long id) {
        return convertToDTO(findById(id));
    }

    public Client createClient(Client client) {
        return repository.save(client);
    }

    public Client updateClient(long id, Client client) {
        Client clientDb = findById(id);

        if (client.getEmails() != null) {
            Set<String> emails = clientDb.getEmails();
            emails.addAll(client.getEmails());
            clientDb.setEmails(emails);
        }
        if (client.getPhones() != null) {
            Set<String> phones = clientDb.getPhones();
            phones.addAll(client.getPhones());
            clientDb.setPhones(phones);
        }
        return repository.save(clientDb);
    }

    public Client getClientContactsById(long id) {
        return findById(id);
    }


    public Set<String> getClientContactsByTypeById(long id, String type) {
        Client client = findById(id);
        Set<String> result = new HashSet<>();
        if (type.equals("email")) {
            result = client.getEmails();
        } else if (type.equals("phone")) {
            result = client.getPhones();
        }
        return result;
    }

    private ClientDTO convertToDTO(Client client){
        return mapper.map(client, ClientDTO.class);
    }

    private Client findById(long id) {
        return repository.findById(id).orElseThrow(ClientNotFoundException::new);
    }
}

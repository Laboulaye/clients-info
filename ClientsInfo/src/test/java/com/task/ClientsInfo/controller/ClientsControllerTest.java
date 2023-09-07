package com.task.ClientsInfo.controller;

import com.task.ClientsInfo.dto.ClientDTO;
import com.task.ClientsInfo.entity.Client;
import com.task.ClientsInfo.service.ClientsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientsControllerTest {

    @Mock
    ClientsService clientsService;

    @InjectMocks
    ClientsController clientsController;

    private ModelMapper mapper;

    private Client client1;
    private Client client2;
    private ClientDTO client1DTO;
    private ClientDTO client2DTO;

    @BeforeEach
    public void init(){
        client1 = new Client(1, "Anthony");
        client2 = new Client(2, "Carmella");

        mapper = new ModelMapper();
        client1DTO = convertToDTO(client1);
        client2DTO = convertToDTO(client2);
    }

    @Test
    public void getAllClientsShouldReturnList()  {
        List<ClientDTO> listDTO = Arrays.asList(client1DTO, client2DTO);
        when(clientsService.getAllClients()).thenReturn(listDTO);

        List<ClientDTO> listResponse = clientsController.getAllClients();
        assertEquals(2, listResponse.size());
    }

    @Test
    public void addClientShouldReturnJsonObject(){
        when(clientsService.createClient(client1)).thenReturn(client1);

        Client clientResponse = clientsController.createClient(client1);
        assertEquals(1, clientResponse.getId());
        assertEquals("Anthony", clientResponse.getName());
    }

    @Test
    public void getClientByIdShouldReturnJsonObject(){
        when(clientsService.getClientById(1)).thenReturn(client1DTO);

        ClientDTO clientResponse = clientsController.getClientById(1);
        assertEquals(1, clientResponse.getId());
        assertEquals("Anthony", clientResponse.getName());
    }

    @Test
    public void updateClientShouldReturnJsonObject(){
        when(clientsService.updateClient(1, client2)).thenReturn(client2);

        Client userResponse = clientsController.updateClient(1, client2);
        assertEquals(2, client2.getId());
        assertEquals("Carmella", userResponse.getName());
    }

    private ClientDTO convertToDTO(Client client){
        return mapper.map(client, ClientDTO.class);
    }
}

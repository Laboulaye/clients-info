package com.task.ClientsInfo.controller;

import com.task.ClientsInfo.dto.ClientDTO;
import com.task.ClientsInfo.entity.Client;
import com.task.ClientsInfo.service.ClientsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ClientsController {

    @Autowired
    private ClientsService service;

    @Operation(summary = "Create new client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Client.class),
                    mediaType = "application/json") })})
    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) {
        return service.createClient(client);
    }

    @Operation(summary = "Add contact info (email, phone) to existing client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Client.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Client not found. Check input id client carefully",
                    content = @Content) })
    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable long id, @RequestBody Client client) {
        return service.updateClient(id, client);
    }

    @Operation(summary = "Get all clients")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(
                    array = @ArraySchema( schema = @Schema(implementation = ClientDTO.class)),
                    mediaType = "application/json") })})
    @GetMapping("/clients")
    public List<ClientDTO> getAllClients() {
        return service.getAllClients();
    }

    @Operation(summary = "Get client by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ClientDTO.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Client not found. Check input id client carefully",
                    content = @Content) })
    @GetMapping("/clients/{id}")
    public ClientDTO getClientById(@PathVariable long id) {
        return service.getClientById(id);
    }

    @Operation(summary = "Get client contacts info by client id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Client.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Client not found. Check input id client carefully",
                    content = @Content) })
    @GetMapping("/clients/{id}/contacts")
    public Client getClientContactsById(@PathVariable long id) {
        return service.getClientContactsById(id);
    }

    @Operation(summary = "Get client contacts info by client id and contact type (email, phone)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Client not found. Check input id client carefully",
                    content = @Content) })
    @GetMapping(value = "/clients/{id}/contacts", params = "type")
    public Set<String> getClientContactsByTypeById(@PathVariable long id,
                                                   @Parameter(name = "type", description = "Type contact", example = "email")
                                                   @RequestParam(name = "type") String type) {
        return service.getClientContactsByTypeById(id, type);
    }
}

package app.controller;

import app.dto.ClientDto;
import app.entity.Client;
import app.mapper.ClientMapper;
import app.service.client_service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<Client> clients = clientService.findAll();
        if (!clients.isEmpty()) {
            List<ClientDto> clientDtos = ClientMapper.getClientDtoFromClient(clients);
            return new ResponseEntity<>(clientDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/clients/add")
    public HttpStatus saveClient(@RequestBody final ClientDto clientDto) {
        if (clientDto != null) {
            Client client = ClientMapper.getClientFromClientDto(clientDto);
            clientService.saveClient(client);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @PostMapping("/clients/update")
    public HttpStatus updateClient(@RequestBody ClientDto clientDto) {
        Client client = clientService.findClientById(clientDto.getId());
        if (client != null) {
            Client updateClient = ClientMapper.updateClientByClientDto(clientDto, client);
            clientService.saveClient(updateClient);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }
}

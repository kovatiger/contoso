package app.service.client_service;

import app.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    List<Client> findAll();

    Client findClientById(Long id);

    void saveClient(Client updateClient);
}

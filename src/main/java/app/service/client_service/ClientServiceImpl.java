package app.service.client_service;

import app.entity.Client;
import app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void saveClient(Client updateClient) {
        clientRepository.save(updateClient);
    }

    @Override
    public Client findClientById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}

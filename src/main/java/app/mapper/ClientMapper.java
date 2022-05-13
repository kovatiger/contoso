package app.mapper;


import app.dto.ClientDto;
import app.entity.Client;
import app.entity.Product;
import app.entity.UserOrder;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper {

    public static List<ClientDto> getClientDtoFromClient(List<Client> clients) {
        List<ClientDto> clientDtos = new ArrayList<>();
        for (Client client : clients) {
            if (client.getUserOrderList().isEmpty()) {
                ClientDto clientDto = new ClientDto();
                clientDto.setId(client.getId());
                clientDto.setNumberOfPhone(client.getTelephone());
                clientDto.setLocation(client.getCity());
                clientDto.setContactName(client.getName());
                clientDto.setEmail(client.getEmail());
                clientDtos.add(clientDto);
            } else {
                for (UserOrder userOrder : client.getUserOrderList()) {
                    ClientDto clientDto = new ClientDto();
                    clientDto.setId(client.getId());
                    clientDto.setNumberOfPhone(client.getTelephone());
                    clientDto.setLocation(client.getCity());
                    clientDto.setContactName(client.getName());
                    clientDto.setEmail(client.getEmail());
                    clientDto.setProductName(userOrder.getProduct().getProduct() + " " + userOrder.getProduct().getName());
                    clientDtos.add(clientDto);
                }
            }
        }
        return clientDtos;
    }

    public static Client updateClientByClientDto(ClientDto clientDto, Client client) {
        client.setEmail(clientDto.getEmail());
        client.setCity(clientDto.getLocation());
        client.setName(clientDto.getContactName());
        client.setTelephone(clientDto.getNumberOfPhone());
        return client;
    }

    public static Client getClientFromClientDto(ClientDto clientDto) {
        Client client = new Client();
        client.setTelephone(clientDto.getNumberOfPhone());
        client.setName(clientDto.getContactName());
        client.setEmail(clientDto.getEmail());
        client.setCity(clientDto.getLocation());
        return client;
    }
}

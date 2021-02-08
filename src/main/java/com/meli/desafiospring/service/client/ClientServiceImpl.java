package com.meli.desafiospring.service.client;

import com.meli.desafiospring.dto.client.ClientDTO;
import com.meli.desafiospring.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean addClient(ClientDTO clientDTO){
        return this.clientRepository.addClientDB(clientDTO);
    }

    public List<ClientDTO> getClients(){
        return this.clientRepository.getAll();
    }

    public List<ClientDTO> getClientsByProvince(String province){
        return this.clientRepository.findClientByProvince(province);
    }
}

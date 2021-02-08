package com.meli.desafiospring.service.client;

import com.meli.desafiospring.dto.client.ClientDTO;

import java.util.List;

public interface ClientService {

    public boolean addClient(ClientDTO clientDTO);

    public List<ClientDTO> getClients();

    public List<ClientDTO> getClientsByProvince(String province);
}

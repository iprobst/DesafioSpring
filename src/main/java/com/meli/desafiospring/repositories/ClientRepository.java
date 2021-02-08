package com.meli.desafiospring.repositories;

import com.meli.desafiospring.dto.client.ClientDTO;

import java.util.List;

public interface ClientRepository {

    List<ClientDTO> getAll();

    boolean addClientDB(ClientDTO newClient);

    List<ClientDTO> findClientByProvince(String province);
}

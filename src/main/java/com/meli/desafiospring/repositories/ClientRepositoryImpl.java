package com.meli.desafiospring.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafiospring.dto.client.ClientDTO;
import com.meli.desafiospring.exceptions.BadRequestException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientRepositoryImpl implements ClientRepository{

    private final List<ClientDTO> database;

    public ClientRepositoryImpl() {
        this.database = loadDataBase();
    }

    @Override
    public List<ClientDTO> findClientByProvince(String province) {
        List<ClientDTO> clientDTO = this.database.stream().filter(client -> client.getProvince().equalsIgnoreCase(province)).collect(Collectors.toList());
        return clientDTO;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<ClientDTO> copyDB = new ArrayList<>();
        copyDB.addAll(this.database);
        return copyDB;
    }

    @Override
    public boolean addClientDB(ClientDTO newClient) {
        if(existClient(newClient.getDni())) throw new BadRequestException("Cliente con dni: " + newClient.getDni() + "ya existe");
        if(newClient.getDni() == null || newClient.getName() == null || newClient.getSurname() == null || newClient.getProvince() == null) throw new BadRequestException("El cliente que se quiere agregar posee datos incompletos.");
        this.database.add(newClient);
        saveDataBase();
        return true;
    }

    public boolean existClient(String dni){
        Optional<ClientDTO> clientDTO = this.database.stream().filter(client -> client.getDni().equals(dni)).findFirst();
        if(clientDTO.isPresent()) return true;

        return false;
    }

    private List<ClientDTO> loadDataBase() {

        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:clients.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TypeReference<List<ClientDTO>> typeRef = new TypeReference<>() {};
        List<ClientDTO> clientes = null;

        try {
            clientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    private void saveDataBase() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/resources/clients.json"), this.database);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

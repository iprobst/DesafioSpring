package com.meli.desafiospring.controller.client;

import com.meli.desafiospring.dto.client.ClientDTO;
import com.meli.desafiospring.service.client.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    @ResponseBody
    public boolean addClient(@RequestBody ClientDTO clientDTO) {
       return this.clientService.addClient(clientDTO);
    }

    @GetMapping()
    public List<ClientDTO> getClients() {
        return this.clientService.getClients();
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<ClientDTO> getClientsByProvince(@RequestParam String province) {

        return this.clientService.getClientsByProvince(province);
    }
}

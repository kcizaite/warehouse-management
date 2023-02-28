package lt.techin.karolina.wearhousemanagementsystem.clients;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static lt.techin.karolina.wearhousemanagementsystem.clients.ClientMapper.toClient;
import static lt.techin.karolina.wearhousemanagementsystem.clients.ClientMapper.toClientDto;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    Logger logger = Logger.getLogger(ClientController.class.getName());
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ClientDto> getClients() {
        logger.info("Clients have been created");
        return clientService.getAll().stream().map(ClientMapper::toClientDto).toList();
    }

    @GetMapping(value = "/client/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClientDto> getClassroom(@PathVariable Long id) {
        logger.log(Level.INFO, "The client is rendered: {0} ", id);
        return ResponseEntity.ok(toClientDto(clientService.finById(id)));
    }

    @PostMapping(value = "/create-client", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> createClient(@RequestBody ClientDto clientDto) {
        var createClient = clientService.create(toClient(clientDto));
        if (createClient == null) {
            logger.info("The client with the given data already exists");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message",
                            "Vartotojas su pateiktais duomenis jau egzsituoja duomenu sistemoje"));
        }
        logger.info("The client was created, successfully");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", (toClientDto(createClient).toString())));
    }
}

package lt.techin.karolina.wearhousemanagementsystem.inventories;

import lt.techin.karolina.wearhousemanagementsystem.clients.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static lt.techin.karolina.wearhousemanagementsystem.clients.ClientMapper.toClientDto;
import static lt.techin.karolina.wearhousemanagementsystem.inventories.InventoryMapper.toInventory;

@RestController
@RequestMapping("/api/v1/inventories")
public class InventoryController {
    Logger logger = Logger.getLogger(InventoryController.class.getName());
    private final InventoryService inventoryService;
    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryService inventoryService, InventoryRepository inventoryRepository) {
        this.inventoryService = inventoryService;
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<InventoryDto> getInventories() {
        logger.info("Inventory was created");
        return inventoryService.getAll().stream().map(InventoryMapper::toInventoryDto).toList();
    }


    @PostMapping(value = "/create-inventory/{clientId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClientDto> createInventory(@RequestBody InventoryDto inventoryDto,
                                                     @PathVariable Long clientId) {
        var addInventoryToClient = inventoryService.create(toInventory(inventoryDto), clientId);
        if (addInventoryToClient == null) {
            logger.log(Level.INFO, "Client was not found with id: {0} ", clientId);
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(null);
        }
        logger.log(Level.INFO, "Inventory was created to client id: {}", clientId);
        return ResponseEntity.status(HttpStatus.CREATED).body(toClientDto(addInventoryToClient));
    }

}

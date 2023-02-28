package lt.techin.karolina.wearhousemanagementsystem.inventories;

import lt.techin.karolina.wearhousemanagementsystem.clients.Client;
import lt.techin.karolina.wearhousemanagementsystem.clients.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private InventoryRepository inventoryRepository;
    private ClientRepository clientRepository;
    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, ClientRepository clientRepository) {
        this.inventoryRepository = inventoryRepository;
        this.clientRepository = clientRepository;
    }

    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    public Inventory finById(Long id) {
        return inventoryRepository.findById(id).orElse(new Inventory());
    }

    public Client create(Inventory inventory, Long clientId) {
        var client = clientRepository.findById(clientId).orElse(null);
        if (client == null) {
            return null;
        } else {
            var saveInventory = inventoryRepository.save(inventory);
            List<Inventory> list = client.getInventory();
            list.add(saveInventory);
            client.setInventory(list);
            return clientRepository.save(client);
        }
    }

    public boolean deleteById(Long id) {
        try {
            inventoryRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }
}

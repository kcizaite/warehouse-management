package lt.techin.karolina.wearhousemanagementsystem.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    @Autowired

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client finById(Long id) {
        return clientRepository.findById(id).orElse(new Client());
    }

    public boolean findByNameSurnameAndBirthdate(String name, String surname, String birthdate) {
        return getAll().stream().anyMatch(client -> client.getName().matches(name)
                && client.getSurname().matches(surname) && client.getBirthdate().matches(birthdate));
    }

    public Client create(Client client) {
        if (client.getName() == null || client.getSurname() == null || client.getBirthdate() == null
        || client.getPhoneNumber() == null || client.getType() == null)
            return null;
        if (findByNameSurnameAndBirthdate(client.getName(), client.getSurname(), client.getBirthdate())) {
            return null;
        } else {
            try {
                return clientRepository.save(client);
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
            return null;
        }
    }
}

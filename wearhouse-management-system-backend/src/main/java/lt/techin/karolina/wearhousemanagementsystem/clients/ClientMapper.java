package lt.techin.karolina.wearhousemanagementsystem.clients;

public class ClientMapper {
    public static ClientDto toClientDto(Client client) {
        var clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setSurname(client.getSurname());
        clientDto.setBirthdate(client.getBirthdate());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setType(client.getType());
        clientDto.setInventory(client.getInventory());
        clientDto.setCreatedDate(client.getCreatedDate());
        return clientDto;
    }

    public static Client toClient(ClientDto clientDto){
        var client = new Client();
        client.setId(client.getId());
        client.setName(client.getName());
        client.setSurname(client.getSurname());
        client.setBirthdate(client.getBirthdate());
        client.setPhoneNumber(client.getPhoneNumber());
        client.setType(client.getType());
        client.setInventory(client.getInventory());
        client.setCreatedDate(client.getCreatedDate());
        return client;
    }
}

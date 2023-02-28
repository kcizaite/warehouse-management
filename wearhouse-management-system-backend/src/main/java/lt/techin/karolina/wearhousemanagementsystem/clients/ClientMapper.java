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
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setBirthdate(clientDto.getBirthdate());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setType(clientDto.getType());
        client.setInventory(clientDto.getInventory());
        client.setCreatedDate(clientDto.getCreatedDate());
        return client;
    }
}

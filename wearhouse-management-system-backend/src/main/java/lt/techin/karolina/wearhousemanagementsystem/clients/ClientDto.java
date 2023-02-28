package lt.techin.karolina.wearhousemanagementsystem.clients;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lt.techin.karolina.wearhousemanagementsystem.inventories.Inventory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ClientDto {
    private Long id;
    private String name;
    private String surname;
    private String birthdate;
    private String phoneNumber;
    private ClientType type;
    private List<Inventory> inventory;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDate;

    public ClientDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(id, clientDto.id) && Objects.equals(name, clientDto.name) && Objects.equals(surname, clientDto.surname) && Objects.equals(birthdate, clientDto.birthdate) && Objects.equals(phoneNumber, clientDto.phoneNumber) && type == clientDto.type && Objects.equals(inventory, clientDto.inventory) && Objects.equals(createdDate, clientDto.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthdate, phoneNumber, type, inventory, createdDate);
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type=" + type +
                ", inventory=" + inventory +
                ", createdDate=" + createdDate +
                '}';
    }
}

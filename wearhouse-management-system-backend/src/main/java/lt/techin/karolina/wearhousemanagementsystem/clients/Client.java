package lt.techin.karolina.wearhousemanagementsystem.clients;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lt.techin.karolina.wearhousemanagementsystem.inventories.Inventory;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank

    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String birthdate;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private ClientType type;
    @OneToMany
    @JoinColumn(name = "clientId")
    private List<Inventory> inventory;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }

    public Client() {
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
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(birthdate, client.birthdate) && Objects.equals(phoneNumber, client.phoneNumber) && type == client.type && Objects.equals(inventory, client.inventory) && Objects.equals(createdDate, client.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthdate, phoneNumber, type, inventory, createdDate);
    }

    @Override
    public String toString() {
        return "Client{" +
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

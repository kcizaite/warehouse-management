package lt.techin.karolina.wearhousemanagementsystem.inventories;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Objects;

public class InventoryDto {
    private Long id;

    private String name;

    private int weight;
    private int sector;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDate;

    public InventoryDto() {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
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
        InventoryDto that = (InventoryDto) o;
        return weight == that.weight && sector == that.sector && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, sector, createdDate);
    }

    @Override
    public String toString() {
        return "InventoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", sector=" + sector +
                ", createdDate=" + createdDate +
                '}';
    }
}

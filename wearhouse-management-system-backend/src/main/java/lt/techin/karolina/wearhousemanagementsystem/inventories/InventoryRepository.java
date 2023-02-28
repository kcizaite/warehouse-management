package lt.techin.karolina.wearhousemanagementsystem.inventories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Query(value = "SELECT * FROM INVENTORY WHERE CLIENT_ID = ?1 ", nativeQuery = true)
    List<Inventory> findInventoryByClientId(Long clientId);
}

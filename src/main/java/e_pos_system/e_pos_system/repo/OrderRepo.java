package e_pos_system.e_pos_system.repo;

import e_pos_system.e_pos_system.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,String> {

}

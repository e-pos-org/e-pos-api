package e_pos_system.e_pos_system.repo;

import e_pos_system.e_pos_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}

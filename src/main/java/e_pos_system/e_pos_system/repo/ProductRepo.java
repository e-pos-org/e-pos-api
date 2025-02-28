package e_pos_system.e_pos_system.repo;

import e_pos_system.e_pos_system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,String> {
}

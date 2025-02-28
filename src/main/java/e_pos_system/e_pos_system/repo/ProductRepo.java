package e_pos_system.e_pos_system.repo;

import e_pos_system.e_pos_system.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,String> {
    @Query(value = "SELECT * FROM product WHERE `title` LIKE %?1% OR description LIKE %?1% ORDER BY title ASC ",nativeQuery = true)
    public Page<Product> findAllWithSearchText(String searchText, Pageable pageable);
    @Query(value = "SELECT COUNT(*) FROM product WHERE `title` LIKE %?1% OR description LIKE %?1% ",nativeQuery = true)
    public long countAllWithSearchText(String searchText);

}

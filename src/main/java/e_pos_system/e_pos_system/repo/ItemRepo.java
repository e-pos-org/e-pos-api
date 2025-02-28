package e_pos_system.e_pos_system.repo;

import e_pos_system.e_pos_system.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,String> {
    @Query(value = "SELECT * FROM item WHERE `title` LIKE %?1% OR description LIKE %?1% OR unit_price LIKE %?1% OR qty LIKE %?1% ORDER BY title ASC",nativeQuery = true)
    public Page<Item> findAllWithSearchText(String searchText, Pageable pageable);
    @Query(value = "SELECT COUNT(*) FROM item WHERE `title` LIKE %?1% OR description LIKE %?1% OR unit_price LIKE %?1% OR qty LIKE %?1%" ,nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}

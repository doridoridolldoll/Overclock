package overclock.overclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import overclock.overclock.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}

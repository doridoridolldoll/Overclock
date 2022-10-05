package overclock.overclock.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.entity.Item;
import overclock.overclock.entity.Posts;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i where i.id = :id ")
    Item findOne(Long id);

    @Query(value = "SELECT i FROM Item i LEFT JOIN Posts p WHERE p.partsType =:category AND p.id = i.id")
    Page<Posts> getItem(Pageable pageable, String category);

}

package overclock.overclock.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.entity.Item;
import overclock.overclock.entity.Posts;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i where i.id = :id ")
    Item findOne(Long id);

    @Query(value = "SELECT i FROM Item i LEFT JOIN Posts p WHERE p.partsType =:category AND p.id = i.id")
    Page<Posts> getItem(Pageable pageable, String category);


    @Query(value = "SELECT i.price as price " +
            "FROM Item i " +
            "LEFT JOIN (SELECT p.id as id, p.partsType as parts_type FROM Posts p) s ON s.id = i.posts2.id " +
            "WHERE s.parts_type =:type ", nativeQuery = true )
    List<Item> getPriceByPartstype(String type);
}

package overclock.overclock.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
//    @Query("select i, ii from Item i " +
//        " left outer join ItemImg ii on ii.item = :i group by i ")
//    Page<Object[]> getListPage(Pageable pageable);

    @Query("select i from Item i where i.id = :id ")
    Item findOne(Long id);
}

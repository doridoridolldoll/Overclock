package overclock.overclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import overclock.overclock.entity.ItemImg;

@Repository
public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {
}

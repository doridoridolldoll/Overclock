package overclock.overclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.entity.ItemImg;

@Transactional
public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {
}

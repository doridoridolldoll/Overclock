package overclock.overclock.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import overclock.overclock.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "SELECT c FROM Cart c " +
            "WHERE c.member.id =:member")
    Page<Cart> getCartList(Pageable pageable, Long member);

}

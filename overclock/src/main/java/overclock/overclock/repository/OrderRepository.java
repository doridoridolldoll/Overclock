package overclock.overclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import overclock.overclock.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

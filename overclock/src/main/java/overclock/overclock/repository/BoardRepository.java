package overclock.overclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import overclock.overclock.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}

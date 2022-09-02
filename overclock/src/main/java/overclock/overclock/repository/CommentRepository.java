package overclock.overclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import overclock.overclock.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}

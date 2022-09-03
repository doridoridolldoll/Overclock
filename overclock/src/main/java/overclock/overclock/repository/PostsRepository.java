package overclock.overclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import overclock.overclock.entity.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
}

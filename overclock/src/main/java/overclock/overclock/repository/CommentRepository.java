package overclock.overclock.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import overclock.overclock.entity.Comment;
import overclock.overclock.entity.Posts;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment c WHERE c.posts.id =:postsId ")
    Page<Comment> commentList(Long postsId, Pageable pageable);
    Comment getByid(Long id);
}

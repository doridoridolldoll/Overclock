package overclock.overclock.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import overclock.overclock.entity.Comment;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment c " +
            "WHERE c.posts.id =:postsId ")
    Page<Comment> commentList(Long postsId, Pageable pageable);

    @Query(value = "SELECT m.name FROM Member m " +
            "WHERE m.id =:memberId")
    String commentName(Long memberId);

    Comment getByid(Long id);
}

package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.repository.CommentRepository;
import overclock.overclock.repository.PostsRepository;

@SpringBootTest
public class CommentTests {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void 댓글생성() {
        Comment comment = new Comment();
        comment.setContent("as");
        comment.setMember(Member.builder().id(1L).build());
        comment.setPosts(Posts.builder().id(1L).build());
        commentRepository.save(comment);
    }
}

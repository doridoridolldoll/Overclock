package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.repository.PostsRepository;

@SpringBootTest
public class CommentTests {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void 댓글생성() {
        Comment comment = new Comment();
    }
}

package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.model.Address;
import overclock.overclock.model.BoardType;
import overclock.overclock.repository.CommentRepository;
import overclock.overclock.repository.PostsRepository;

import java.util.stream.IntStream;

@SpringBootTest
public class CommentTests {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void 댓글생성() {
//        Comment comment = new Comment();
//        comment.setContent("as");
//        comment.setMember(Member.builder().id(1L).build());
//        comment.setPosts(Posts.builder().id(1L).build());
//        commentRepository.save(comment);

        IntStream.rangeClosed(1,100).forEach(i -> {
            Long id = (long) (Math.random() * 100) + 1;
            Member member = Member.builder().id(id).build();
            Comment comment = Comment.builder()
                    .content("as" + i)
                    .member(Member.builder().id(id).build())
                    .posts(Posts.builder().id(id).build())
                    .build();
            commentRepository.save(comment);
        });
    }
}

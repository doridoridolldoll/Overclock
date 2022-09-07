package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.model.Address;
import overclock.overclock.model.BoardType;
import overclock.overclock.repository.CommentRepository;
import java.util.stream.IntStream;
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
            long post_id = (long)(Math.random() * 100) + 1;
            Posts posts = Posts.builder().id(post_id).build();
            long member_id = (long)(Math.random() * 100) + 1;
            Member member = Member.builder().id(member_id).build();
            Comment comment = Comment.builder()
                    .content("asd")
                    .posts(posts)
                    .member(member)
                    .build();
            commentRepository.save(comment);
        });
        Comment comment = new Comment();
        comment.setContent("as");
        comment.setMember(Member.builder().id(1L).build());
        comment.setPosts(Posts.builder().id(1L).build());
        commentRepository.save(comment);
    }
}

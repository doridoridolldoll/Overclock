package overclock.overclock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.entity.Address;
import overclock.overclock.entity.Board;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;
import overclock.overclock.model.BoardType;
import overclock.overclock.model.MemberRole;
import overclock.overclock.repository.PostsRepository;

import java.util.stream.IntStream;

@SpringBootTest
public class PostsTests {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void insertPosts(){
        Member member = Member.builder().id(1L).email("asas").build();
        Board board = Board.builder().id(1L).boardType(BoardType.SALE).build();
        Posts posts = Posts.builder()
                .title("title")
                .member(member)
                .viewCount(1)
                .board(board)
//                .writer(String.valueOf(member))
                .build();
        postsRepository.save(posts);
    }

}

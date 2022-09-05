package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.model.BoardType;
import overclock.overclock.repository.PostsRepository;

@SpringBootTest
public class PostsTests {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void insertPosts(){
        Member member = Member.builder().id(1L).email("asas").build();
        Posts posts = Posts.builder()
                .title("title")
                .member(member)
                .viewCount(1)
                .boardType(BoardType.MARKET)
//                .writer(String.valueOf(member))
                .build();
        postsRepository.save(posts);
    }

}

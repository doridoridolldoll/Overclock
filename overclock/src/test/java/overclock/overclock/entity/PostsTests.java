package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.model.Address;
import overclock.overclock.model.BoardType;
import overclock.overclock.repository.PostsRepository;

import java.util.Arrays;

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
                .address(Address.builder().city("as").street("as").zipcode("as").build())
                .build();
        postsRepository.save(posts);
    }

    @Test
//    @Transactional
    public void testReadWithMember(){
        Object result = postsRepository.getPostsWithMember(1L);
        System.out.println(result);
        Object[] arr = (Object[]) result;
        System.out.println("-----------------------");
        System.out.println(Arrays.toString(arr));
    }

}

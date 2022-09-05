package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.web.WebAppConfiguration;
import overclock.overclock.model.Address;
import overclock.overclock.model.BoardType;
import overclock.overclock.repository.PostsRepository;

import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootTest
@WebAppConfiguration
public class PostsTests {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void insertPosts(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Long id = (long)(Math.random()*100)+1;
            Member member = Member.builder().id(id).build();
            Posts posts = Posts.builder()
                    .title("title")
                    .member(member)
                    .viewCount(1)
                    .boardType(BoardType.MARKET)
                    .address(Address.builder().city("as").street("as").zipcode("as").build())
                    .build();
            postsRepository.save(posts);
        });

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

    @Test
    public void testWithMemberPage(){
        Pageable pageable = PageRequest.of(0,10, Sort.by("post_id").descending());

        Page<Object[]> result = postsRepository.getPostsWithMemberPage(pageable);

        result.get().forEach(row -> {
            Object[] arr = (Object[]) row;
            System.out.println(Arrays.toString(arr));
        });
    }


}
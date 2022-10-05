package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.model.Address;
import overclock.overclock.model.BoardType;
import overclock.overclock.repository.PostsRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@WebAppConfiguration
public class PostsTests {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void insertPosts(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Long id = (long)(Math.random()*20)+1;
            Member member = Member.builder().id(id).build();
            Posts posts = Posts.builder()
                    .title("title")
                    .member(member)
                    .content("content"+i)
                    .boardType(BoardType.MARKET)
                    .address(Address.builder().city("as").street("as").zipcode("as").build())
                    .build();
            postsRepository.save(posts);
        });

    }


}

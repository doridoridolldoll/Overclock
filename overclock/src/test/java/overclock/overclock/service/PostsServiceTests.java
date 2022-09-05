package overclock.overclock.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.dto.PostsDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostsServiceTests {
    @Autowired
    private PostsService postsService;

    @Test
    public void testRegister(){
        PostsDTO dto = PostsDTO.builder()
                .title("Test.asd")
                .content("Test...")
                .memberId(1L)
                .build();
        Long id = postsService.register(dto);
    }

}
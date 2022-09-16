//package overclock.overclock.service;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import overclock.overclock.dto.PageRequestDTO;
//import overclock.overclock.dto.PageResultDTO;
//import overclock.overclock.dto.PostsDTO;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class PostsServiceTests {
//    @Autowired
//    private PostsService postsService;
//
//    @Test
//    public void testRegister(){
//        PostsDTO dto = PostsDTO.builder()
//                .title("Test.asd")
//                .content("Test...")
//                .memberId(1L)
//                .build();
//        Long id = postsService.mregister(dto);
//    }
//
//    @Test
//    public void testList(){
//        PageRequestDTO pageRequestDTO = new PageRequestDTO();
//
//        PageResultDTO<PostsDTO, Object[]> result = postsService.getList(pageRequestDTO);
//        for (PostsDTO postsDTO : result.getDtoList()){
//            System.out.println(postsDTO);
//        }
//    }
//}
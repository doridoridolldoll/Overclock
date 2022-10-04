//package overclock.overclock.service;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import overclock.overclock.dto.PageRequestDTO;
//import overclock.overclock.dto.PageResultDTO;
//import overclock.overclock.dto.PostsDTO;
//import overclock.overclock.entity.Posts;
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
//    //    @Test
////    public void testList(){
////        PageRequestDTO pageRequestDTO = new PageRequestDTO();
////
////        PageResultDTO<PostsDTO, Object[]> result = postsService.getList(pageRequestDTO);
////        for (PostsDTO postsDTO : result.getDtoList()){
////            System.out.println(postsDTO);
////        }
////    }
//    @Test
//    @Transactional
//    public void testSearch() {
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .page(1)
//                .size(10)
//                .type("tc")
//                .keyword("1")
//                .build();
//        System.out.println("---------------------------------------");
//        PageResultDTO<PostsDTO, Posts> resultDTO = postsService.getList3(pageRequestDTO);
//
//        System.out.println("PREV: "+resultDTO.isPrev());
//        System.out.println("NEXT: "+resultDTO.isNext());
//        System.out.println("TOTAL: "+resultDTO.getTotalPage());
//
//        System.out.println("---------------------------------------");
//        for (PostsDTO postsDTO : resultDTO.getDtoList()) {
//            System.out.println(postsDTO);
//        }
//
//        System.out.println("---------------------------------------");
//        resultDTO.getPageList().forEach(i -> System.out.println(i));
//
//
//    }
//}
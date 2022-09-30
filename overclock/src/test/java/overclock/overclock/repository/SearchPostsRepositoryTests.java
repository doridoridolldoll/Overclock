package overclock.overclock.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class SearchPostsRepositoryTests {

    @Autowired
    PostsRepository repository;

//    @Test
//    @Transactional
//    public void testSearchPage(){
//        Pageable pageable = PageRequest.of(0,10, Sort.by("id")
//                .descending().and(Sort.by("title").ascending()));
//        System.out.println("-----------------------------------------------------------------");
//        System.out.println(pageable);
//        System.out.println("-----------------------------------------------------------------");
//        Page<Object[]> result = repository.searchPage("t", "1", pageable);
//        System.out.println("-----------------------------------------------------------------");
//        System.out.println(result);
//        System.out.println("-----------------------------------------------------------------");
//    }
}

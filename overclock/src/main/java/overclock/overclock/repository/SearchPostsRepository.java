package overclock.overclock.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import overclock.overclock.entity.Posts;

public interface SearchPostsRepository {

    Posts search1();
    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}

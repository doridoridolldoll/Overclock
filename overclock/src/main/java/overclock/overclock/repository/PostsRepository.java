package overclock.overclock.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import overclock.overclock.entity.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("select p, m from Posts p left join p.member m where p.id =:id")
    Object getPostsWithMember(@Param("id") Long id);

    //게시물 화면에 필요한 데이터 추출
    @Query("select p, m from Posts p left join p.member m where p.id =:id")
    Page<Object[]> getPostsWithMemberPage(Pageable pageable);


}

package overclock.overclock.repository;

import com.querydsl.core.BooleanBuilder;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.entity.Posts;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Posts, String > {



    @EntityGraph(attributePaths = { "member" }, type = EntityGraph.EntityGraphType.LOAD)
    @Query(
            value = "select c from Posts c ",
            countQuery = "select count(c) from Posts c"
    )
    Page<Posts> getPageList(Pageable pageable);


    @Query(value = "SELECT p FROM Posts p WHERE p.partsType =:category")
    Page<Posts> getPartsByCategoryPageList(Pageable pageable, String category);


    @Modifying
    @Query("update Posts p set p.view = p.view + 1 where p.id = :id ")
    void updateView(Long id);

    Posts getByid(Long id);

    @Query("SELECT p.id as id, p.title as title, p.content as content, m.nickname as nickname " +
            "FROM Posts p " +
            "LEFT JOIN Member m ON p.member.id = m.id " +
            "WHERE p.title LIKE CONCAT('%',:search,'%') ")
    Optional<List<getEmbedCardsInformation>> getSearchList(String search);

    @Query("SELECT p.id, p.title " +
            "FROM Posts p left join Member m on m.id = p.id " +
            "where p.title LIKE CONCAT('%',:search,'%') " +
            "group by p.id")
    Page<Posts> getListAndAuthorByAuthorOrTitlePage(String search, Pageable pageable);

    @Query("SELECT p FROM Posts p WHERE p_id =:userid and id=:id ")
    Optional<Posts> getArticleByAidAndUserId(Long id, Long userid);

    void deleteById(Long id);


    public interface getEmbedCardsInformation {
        Long getId();

        String getTitle();

        String getContent();

        String getNickname();

    }

}


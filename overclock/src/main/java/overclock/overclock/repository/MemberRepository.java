package overclock.overclock.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import overclock.overclock.dto.ItemDTO;
import overclock.overclock.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface MemberRepository extends JpaRepository<Member, Long> {


    @Query("select m from Member m where m.id = :id ")
    Member findOne(Long id);

    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from Member m where m.email=:email and m.fromSocial=:social ")
    Optional<Member> findByEmail(@Param("email") String email,@Param("social") boolean social);



//    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("select m from Member m where m.id=:id")
//    Optional<Member> findById(String id);

//    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("select m from Member m where m.fromSocial = :fromSocial and m.email =:email")
//    Optional<Member> findByEmailWithAuth(String email, boolean fromSocial);

    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from Member m where m.email=:email ")
    Optional<Member> findByEmail12(String email);

    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from Member m where m.phone=:phone ")
    Optional<Member> findByPhone(String phone);
    Member findUserByEmail(String email);
//    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("select m from Member m where m.email=:email")
//    Optional<Member> findUserById(String email);

//    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("select m from Member m where m.id=:id and m.password=:password")
//    Optional<Member> updateUserPassword(Long id, String password);

//    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("select m from Member m where m.id=:id ")
//    Optional<Member> findById(Long id, String password);

    @Query("select m from Member m where m.email=:email ")
    Optional<Member> findIdByEmail(String email);
}

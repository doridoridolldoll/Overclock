package overclock.overclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import overclock.overclock.entity.Member;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface MemberRepository extends JpaRepository<Member, Long> {


    Member findByEmail(String email);

    public List<Member> findByName(String name);

    @Query("select m from Member m where m.id = :id ")
    Member findOne(Long id);

}

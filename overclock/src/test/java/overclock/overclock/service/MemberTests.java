package overclock.overclock.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import overclock.overclock.entity.Member;
import overclock.overclock.model.MemberRole;
import overclock.overclock.repository.MemberRepository;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberTests {


        @Autowired
        private MemberRepository repository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Test
        public void insertDummies() {

            //1~ 80까지는 USER만 지정
            //80~ 90까지는 USER,MANAGER
            //91~ 100까지는 USER,MANAGER,ADMIN

            IntStream.rangeClosed(1, 100).forEach(i -> {
                Member member = Member.builder()
                        .email("user" + i + "@as.com")
                        .name("사용자" + i)
                        .nickname("as" + i)
                        .phone("010"+ i)
                        .auth(false)
                        .password(passwordEncoder.encode("1111"))
                        .build();

                //default role
                member.addMemberRole(MemberRole.USER);

                if (i > 80) {
                    member.addMemberRole(MemberRole.ADMIN);
                }
                repository.save(member);
            });
        }
    @Test
    public void testRead() {

        Optional<Member> result = repository.findByEmail("as", false);

        Member member = result.get();

        System.out.println(member);
    }

}

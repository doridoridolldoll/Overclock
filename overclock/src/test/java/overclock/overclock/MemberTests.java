package overclock.overclock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.entity.Address;
import overclock.overclock.entity.Member;
import overclock.overclock.model.MemberRole;
import overclock.overclock.repository.MemberRepository;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberTests {

  @Autowired
  MemberRepository repository;

  @Test
  public void insertMembers(){
    IntStream.rangeClosed(1, 100).forEach(i -> {
      Address address = new Address("as","as","as");
      Member member = Member.builder()
              .email("user"+i+"@aaa.com")
              .nickname("cat"+i)
              .role(MemberRole.USER)
              .password("1")
              .name("USER"+i)
              .phone("010"+i)
              .address(address)
              .build();
      repository.save(member);
    });
  }
}

package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.model.Address;
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
      Member member = Member.builder()
              .email("user"+i+"@aaa.com")
              .nickname("cat"+i)
              .password("1")
              .name("USER"+i)
              .phone("010"+i)
              .role(MemberRole.USER)
              .phone("010")
              .address(Address.builder()
                      .city("busan")
                      .street("street")
                      .zipcode("123")
                      .build())
              .build();
    repository.save(member);
    });
  }
}

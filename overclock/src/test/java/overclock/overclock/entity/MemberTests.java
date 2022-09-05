package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
//import overclock.overclock.entity.Address;
import overclock.overclock.entity.Address;
import overclock.overclock.entity.Member;
import overclock.overclock.model.MemberRole;
import overclock.overclock.repository.MemberRepository;

import javax.persistence.EntityManager;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberTests {

  @Autowired
  MemberRepository repository;


  @Test
  public void insertMembers(){
    IntStream.rangeClosed(1, 100).forEach(i -> {
<<<<<<< HEAD:overclock/src/test/java/overclock/overclock/MemberTests.java
      Address address = new Address("as", "as", "as");
=======


>>>>>>> de3a84c347d4ddddbe39ccf93cc56fa2a7ce1b99:overclock/src/test/java/overclock/overclock/entity/MemberTests.java
      Member member = Member.builder()
              .email("user"+i+"@aaa.com")
              .nickname("cat"+i)
              .password("1")
              .name("USER"+i)
<<<<<<< HEAD:overclock/src/test/java/overclock/overclock/MemberTests.java
              .phone("010"+i)
              .address(address)
              .role(MemberRole.USER)
=======
              .phone("010")
              .role(MemberRole.USER)
              .address(Address.builder()
                      .city("busan")
                      .street("street")
                      .zipcode("123")
                      .build())
>>>>>>> de3a84c347d4ddddbe39ccf93cc56fa2a7ce1b99:overclock/src/test/java/overclock/overclock/entity/MemberTests.java
              .build();
    repository.save(member);
    });
  }
}

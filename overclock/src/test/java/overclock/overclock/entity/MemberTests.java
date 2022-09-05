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
    IntStream.rangeClosed(300, 400).forEach(i -> {
      Address address = new Address("as", "as", "as");


      Member member = Member.builder()
              .email("user"+i+"@aaa.com")
              .nickname("cat"+i)
              .password("1")
              .name("USER"+i)
              .phone("010"+i)
              .address(address)
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

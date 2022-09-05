package overclock.overclock.entity;

<<<<<<< HEAD
import lombok.AccessLevel;
=======
import lombok.Builder;
>>>>>>> de3a84c347d4ddddbe39ccf93cc56fa2a7ce1b99
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
<<<<<<< HEAD
// Embeddable 어노테이션 사용하면 protected
@NoArgsConstructor(access = AccessLevel.PROTECTED)
=======
@Builder
>>>>>>> de3a84c347d4ddddbe39ccf93cc56fa2a7ce1b99
public class Address{

    private String city; // 도시
    private String street; // 도로명
    private String zipcode; // 우편번호

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}

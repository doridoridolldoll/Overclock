package overclock.overclock.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
// Embeddable 어노테이션 사용하면 protected
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
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

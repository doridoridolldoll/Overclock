package overclock.overclock.entity;

import lombok.*;
import overclock.overclock.model.Address;
import overclock.overclock.model.MemberRole;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Builder
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String name;

    private String password;

    private String nickname;

    private String phone;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Embedded
    private Address address;

//    @OneToMany(mappedBy = "member")
//    private List<Order> order = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<Posts> posts = new ArrayList<>();

    @Builder
    public Member(String email, String name, String password, String nickname,
                  String phone, MemberRole role, Address address) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }
}

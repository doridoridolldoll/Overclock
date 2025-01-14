package overclock.overclock.entity;

import lombok.*;
import overclock.overclock.dto.JoinFormDTO;
import overclock.overclock.dto.MemberDTO;
import overclock.overclock.model.Address;
import overclock.overclock.model.MemberRole;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
    @Column
    private boolean auth;
    @Enumerated(EnumType.STRING)
    private MemberRole role;
    @Embedded
    private Address address;
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

//    @OneToMany(mappedBy = "member")
//    private List<Order> order = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<Posts> posts = new ArrayList<>();

    @Builder
    public Member(Long id, String email, String name, String password, String nickname,
                  String phone, MemberRole role, Address address) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public static Member createMember(MemberDTO memberDTO) {
        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member.setAddress(memberDTO.getCity(), memberDTO.getStreet(), memberDTO.getZipcode());
        member.setPassword(memberDTO.getPassword());
        member.setRole(MemberRole.ADMIN);
        return member;
    }

    private void setAddress(String city, String street, String zipcode) {}
    public void addMemberRole(MemberRole role){
        roleSet.add(role);
    }

}

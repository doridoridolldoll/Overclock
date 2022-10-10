//package overclock.overclock.entity;
//
//import lombok.*;
//import overclock.overclock.model.Address;
//import overclock.overclock.model.MemberRole;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@ToString
//public class CpMember extends BaseEntity{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    //사업자 등록번호
//    private int cpcode;
//
//    private String name;
//
//    private String password;
//
//    @Embedded
//    private Address address;
//
//    @ElementCollection(fetch = FetchType.LAZY)
//    @Builder.Default
//    private Set<MemberRole> roleSet = new HashSet<>();
//
//    @Builder
//    public CpMember(String name, String password, int cpcode, Address address) {
//        this.name = name;
//        this.password = password;
//        this.cpcode = cpcode;
//        this.address = address;
//    }
//    public void addMemberRole(MemberRole role){
//        roleSet.add(role);
//    }
//
//
//}

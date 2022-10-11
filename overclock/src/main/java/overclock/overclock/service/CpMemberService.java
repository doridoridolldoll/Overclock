//package overclock.overclock.service;
//
//import overclock.overclock.dto.CpMemberDTO;
//import overclock.overclock.dto.MemberDTO;
//import overclock.overclock.entity.CpMember;
//import overclock.overclock.entity.Member;
//import overclock.overclock.model.Address;
//import overclock.overclock.model.MemberRole;
//
//import java.util.stream.Collectors;
//
//public interface CpMemberService {
//
//    String companyRegister(CpMemberDTO cpMemberDTO);
//
//    default CpMember dtoToEntity(CpMemberDTO dto) {
//        Address address = new Address(dto.getCity(), dto.getStreet(), dto.getZipcode());
//        CpMember cpmember = CpMember.builder()
//                .id(dto.getId())
//                .name(dto.getName())
//                .cpcode(dto.getCpcode())
//                .password(dto.getPassword())
//                .address(address)
//                .roleSet(dto.getRoleSet().stream().map(
//                        t -> {
//                            if (t.equals("ROLE_MEMBER"))
//                                return MemberRole.USER;
//                            else if (t.equals("ROLE_ADMIN"))
//                                return MemberRole.ADMIN;
//                            else
//                                return MemberRole.USER;
//                        }).collect(Collectors.toSet()))
//                .build();
//        return cpmember;
//    }
//
//    default CpMemberDTO EntityToDTO(CpMember cpMember) {
//        CpMemberDTO cpMemberDTO = CpMemberDTO.builder()
//                .id(cpMember.getId())
//                .name(cpMember.getName())
//                .password(cpMember.getPassword())
//                .cpcode(cpMember.getCpcode())
//                .build();
//        return cpMemberDTO;
//    }
//}

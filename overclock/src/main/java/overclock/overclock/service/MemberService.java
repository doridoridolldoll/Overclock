package overclock.overclock.service;

import overclock.overclock.dto.MemberDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.model.Address;
import overclock.overclock.model.MemberRole;

import java.util.Optional;
import java.util.stream.Collectors;

public interface MemberService {
    String modify(MemberDTO dto);
    Optional mList(MemberDTO memberDTO);

    String memberRegister(MemberDTO memberDTO);
    Optional findByPhone(MemberDTO phone);
    Optional findByEmail(MemberDTO email);
    boolean userEmailCheck(String email);
    String passChange(MemberDTO dto);

//    String companyRegister(MemberDTO memberDTO);


    default Member dtoToEntity(MemberDTO dto) {
        Address address = new Address(dto.getCity(), dto.getStreet(), dto.getZipcode());
        Member member = Member.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .nickname(dto.getNickname())
                .password(dto.getPassword())
                .address(address)
                .fromSocial(dto.isFromSocial())
//                .crn(dto.getCrn())
                .roleSet(dto.getRoleSet().stream().map(
                        t -> {
                            if (t.equals("ROLE_MEMBER"))
                                return MemberRole.USER;
                            else if (t.equals("ROLE_ADMIN"))
                                return MemberRole.ADMIN;
                            else
                                return MemberRole.USER;
                        }).collect(Collectors.toSet()))
                .build();
        return member;
    }

    default MemberDTO EntityToDTO(Member member) {
        MemberDTO memberDTO = MemberDTO.builder()
                .id(member.getId())
                .email(member.getEmail())
                .name(member.getName())
                .phone(member.getPhone())
                .password(member.getPassword())
                .fromSocial(member.isFromSocial())
//                .crn(member.getCrn())
                .build();
                return memberDTO;
    }


}
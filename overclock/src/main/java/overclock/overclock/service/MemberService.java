package overclock.overclock.service;

import overclock.overclock.dto.MemberDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.model.Address;
import overclock.overclock.model.MemberRole;

import java.util.List;

public interface MemberService {

    List<Member> findMember();
    Long join(MemberDTO memberDTO);

    Member saveMember(Member member);

    default Member dtoToEntity(MemberDTO dto) {
        Address address = new Address(dto.getCity(), dto.getStreet(), dto.getZipcode());
        MemberRole memberRole = MemberRole.USER;
        Member member = Member.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .nickname(dto.getNickname())
                .password(dto.getPassword())
                .address(address)
                .role(memberRole)
                .build();
        return member;
    }

    default MemberDTO entityToDTO(Member member) {
        MemberDTO memberDTO = MemberDTO.builder()
                .id(member.getId())
                .email(member.getEmail())
                .name(member.getName())
                .phone(member.getPhone())
                .password(member.getPassword())
                .build();

                return memberDTO;
    }












}
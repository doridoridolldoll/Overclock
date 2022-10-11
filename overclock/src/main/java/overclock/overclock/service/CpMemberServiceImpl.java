//package overclock.overclock.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.stereotype.Service;
//import overclock.overclock.dto.CpMemberDTO;
//import overclock.overclock.dto.MemberDTO;
//import overclock.overclock.entity.CpMember;
//import overclock.overclock.model.MemberRole;
//import overclock.overclock.repository.CpMemberRepository;
//
//@Service
//@RequiredArgsConstructor
//@Log4j2
//public class CpMemberServiceImpl implements CpMemberService{
//
//    private  final CpMemberRepository cpMemberRepository;
//    @Override
//    public String companyRegister(CpMemberDTO cpMemberDTO) {
//        log.info("CpMemberDTO : {}", cpMemberDTO);
//        cpMemberDTO.setPassword(BCrypt.hashpw(cpMemberDTO.getPassword(), BCrypt.gensalt()));
//        CpMember cpMember = dtoToEntity(cpMemberDTO);
//        cpMember.addMemberRole(MemberRole.COMPANY);
//        cpMemberRepository.save(cpMember);
//        return cpMember.getName();
//    }
//    //    @Override
////    public String companyRegister(MemberDTO memberDTO) {
////        log.info("company MemberDTO : {}", memberDTO);
////        memberDTO.setPassword(BCrypt.hashpw(memberDTO.getPassword(), BCrypt.gensalt()));
////        Member member = dtoToEntity(memberDTO);
////        member.addMemberRole(MemberRole.COMPANY);
////        memberRepository.save(member);
////        return member.getEmail();
////    }
//}

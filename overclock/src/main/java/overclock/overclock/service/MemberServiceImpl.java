package overclock.overclock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.dto.MemberDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.model.MemberRole;
import overclock.overclock.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    @Override
    public String modify(MemberDTO memberDTO) {
        log.info("Member DTO : {}",memberDTO);
        Optional<Member> modifyList = memberRepository.findByEmail(memberDTO.getEmail(), memberDTO.isFromSocial());
        log.info(modifyList);


        return null;
    }

    @Transactional //변경
    public String memberRegister(MemberDTO memberDTO) {
        memberDTO.setPassword(BCrypt.hashpw(memberDTO.getPassword(), BCrypt.gensalt()));
        Member member = dtoToEntity(memberDTO);
        member.addMemberRole(MemberRole.USER);
        memberRepository.save(member);
        return member.getEmail();
    }

//    private void validateDuplicateMember(MemberDTO memberDTO) {
//
//        List<Member> findMembers = memberRepository.findByName(memberDTO.getName());
//        if (!findMembers.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }
//    }
}

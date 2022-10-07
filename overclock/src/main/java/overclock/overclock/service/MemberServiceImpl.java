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

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    @Transactional //변경
    public String memberRegister(MemberDTO memberDTO) {
        memberDTO.setPassword(BCrypt.hashpw(memberDTO.getPassword(), BCrypt.gensalt()));
        Member member = dtoToEntity(memberDTO);
        member.addMemberRole(MemberRole.USER);
        memberRepository.save(member);
        return member.getEmail();
    }

//    @Override
//    public String companyRegister(MemberDTO memberDTO) {
//        log.info("company MemberDTO : {}", memberDTO);
//        memberDTO.setPassword(BCrypt.hashpw(memberDTO.getPassword(), BCrypt.gensalt()));
//        Member member = dtoToEntity(memberDTO);
//        member.addMemberRole(MemberRole.COMPANY);
//        memberRepository.save(member);
//        return member.getEmail();
//    }

    @Override
    public String modify(MemberDTO dto) {
        log.info("dto : " + dto);
        Member entity = memberRepository.getReferenceById(dto.getId());
        log.info("entity : " + entity);
        MemberDTO getById = EntityToDTO(entity);
        log.info("getById : " + getById);
        getById.setPassword(dto.getPassword());
        getById.setNickname(dto.getNickname());
        getById.setStreet(dto.getStreet());
        getById.setCity(dto.getCity());
        getById.setZipcode(dto.getZipcode());

        Member modifiedMember = dtoToEntity(getById);
        memberRepository.save(modifiedMember);

        return modifiedMember.getId().toString();
    }

    @Override
    public Optional mList(MemberDTO dto) {
        Optional<Member> result = memberRepository.findByEmail12(dto.getEmail());
        log.info("dto.getEmail : {}", result);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    @Override
    public Optional findByPhone(MemberDTO dto) {
        Optional<Member> result = memberRepository.findByPhone(dto.getPhone());
        log.info("result : " + result);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    @Override
    public Optional findByEmail(MemberDTO email) {
        log.info("member DTO email : {}", email.getEmail());

        Optional<Member> result = memberRepository.findIdByEmail(email.getEmail());
        log.info("findByEmail result : {}", result);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    @Override
    public boolean userEmailCheck(String email) {
        Member member = memberRepository.findUserByEmail(email);
        if(member!=null && member.getEmail().equals(email)) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public String passChange(MemberDTO dto) {
        Member entity = memberRepository.getReferenceById(dto.getId());
        MemberDTO getById = EntityToDTO(entity);
        getById.setPassword(encoder.encode(dto.getPassword()));
        Member passChange = dtoToEntity(getById);
        memberRepository.save(passChange);

        return passChange.getId().toString();
    }

}

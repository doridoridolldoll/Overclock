package overclock.overclock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.dto.MemberDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;
import overclock.overclock.model.MemberRole;
import overclock.overclock.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional //변경
    public Long join(MemberDTO memberDTO) {

        Member member = dtoToEntity(memberDTO);
        member.setRole(MemberRole.USER);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(MemberDTO memberDTO) {

        List<Member> findMembers = memberRepository.findByName(memberDTO.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Override
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    public void validateDuplicateMember(Member member) {
        Member findMember = (Member) memberRepository.findByEmail(member.getEmail());

        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}

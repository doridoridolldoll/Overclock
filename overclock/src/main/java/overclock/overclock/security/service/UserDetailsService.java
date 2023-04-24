package overclock.overclock.security.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import overclock.overclock.entity.Member;
import overclock.overclock.repository.MemberRepository;
import overclock.overclock.security.dto.AuthMemberDTO;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final MemberRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("loadUserByUsername: " + email);

        Optional<Member> result = repository.findByEmail(email, false);
        if (!result.isPresent()) {
            throw new UsernameNotFoundException("Check email or Social");
        }
        Member member = result.get();
        log.info("Overclock 유저정보: " + member);

        AuthMemberDTO dto = new AuthMemberDTO(
                member.getEmail(),
                member.getPassword(),
                member.isFromSocial(),
                member.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                        .collect(Collectors.toList()));

        dto.setName(member.getName());
        dto.setId(member.getId());
        return dto;
    }
}

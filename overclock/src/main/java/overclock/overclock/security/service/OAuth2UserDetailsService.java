package overclock.overclock.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import overclock.overclock.dto.MemberDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.model.MemberRole;
import overclock.overclock.repository.MemberRepository;
import overclock.overclock.security.dto.AuthMemberDTO;

import java.util.Optional;
import java.util.stream.Collectors;

import static overclock.overclock.model.MemberRole.*;

@Log4j2
@Service
@RequiredArgsConstructor
public class OAuth2UserDetailsService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        log.info("------------------------------");
        log.info("userRequest: {}", userRequest.toString());

        String clientName = userRequest.getClientRegistration().getClientName();

        log.info("clientName: " + clientName);
        log.info(userRequest.getAdditionalParameters());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        log.info("========================");
        oAuth2User.getAttributes().forEach((k,v) -> {
            log.info(k + ":" + v);
        });

        String email = null;

        if(clientName.equals("Google")){
            email = oAuth2User.getAttribute("email");
        }
        log.info("EMAIL: {}", email);

        Member member = saveSocialMember(email);
        AuthMemberDTO dto = new AuthMemberDTO(

                member.getEmail(),
                member.getPassword(),
                true,
                member.getRoleSet().stream().map(

                        role -> new SimpleGrantedAuthority("ROLE_" + role.name())).
                        collect(Collectors.toList()),
                oAuth2User.getAttributes());



        return dto;

    }
    private Member saveSocialMember(String email){
        Optional<Member> result = memberRepository.findByEmail(email, true);

        if(result.isPresent()){
            log.info("result : {}", result);
            return result.get();
        }
        Member member = Member.builder()
                .email(email)
                .name(email)
                .password(passwordEncoder.encode("1111"))
                .fromSocial(true)
                .build();
        member.addMemberRole(USER);
        log.info("member : {} ",member);
        memberRepository.save(member);

        return member;
    }
}

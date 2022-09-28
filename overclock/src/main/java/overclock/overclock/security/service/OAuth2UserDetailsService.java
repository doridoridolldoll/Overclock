package overclock.overclock.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import overclock.overclock.entity.Member;
import overclock.overclock.model.MemberRole;
import overclock.overclock.repository.MemberRepository;

import java.util.Optional;

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
        String name = null;

        if(clientName.equals("Google")){
            email = oAuth2User.getAttribute("email");
            name = oAuth2User.getAttribute("name");
        }
        log.info("EMAIL: {}", email);
        log.info("name: {}", name);

        Member member = saveSocialMember(email);

        return oAuth2User;
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
        memberRepository.save(member);

        return member;
    }
}

//package overclock.overclock.security.service;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import overclock.overclock.entity.Member;
//import overclock.overclock.repository.MemberRepository;
//import overclock.overclock.security.dto.AuthMemberDTO;
//
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//@Log4j2
//@RequiredArgsConstructor
//public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
//
//    private final MemberRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        log.info("loadUserByUsername: " + email);
//
//        Optional<Member> result = repository.findByEmail(email);
//        if (!result.isPresent()) {
//            throw new UsernameNotFoundException("Check email or Social");
//        }
//        Member entity = result.get();
//        log.info("airUser 유저정보: " + entity);
//
//        AuthMemberDTO dto = new AuthMemberDTO(
//                entity.getEmail(), entity.getPassword(), entity.getId(),
//                entity.isAuth(),
//                entity.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
//                        .collect(Collectors.toList()));
//        dto.setName(entity.getName());
//        dto.setAuth(entity.isAuth());
//        return dto;
//    }
//}

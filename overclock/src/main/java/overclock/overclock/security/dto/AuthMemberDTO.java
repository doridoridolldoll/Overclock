package overclock.overclock.security.dto;


import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.*;
import org.springframework.security.oauth2.core.user.OAuth2User;
import overclock.overclock.model.Address;

@Getter
@Setter
@ToString
public class AuthMemberDTO extends User implements OAuth2User {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String curl;

    private boolean fromSocial;

    public AuthMemberDTO(
         String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities, Map<String, Object> attr) { // 구글에서 넘어온 정보
         this(username, password, fromSocial, authorities);

         this.attr = attr;
    }
    public AuthMemberDTO(String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        email = username;
        this.password = password;
        this.fromSocial = fromSocial;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attr;

    }
}

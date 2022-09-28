package overclock.overclock.security.dto;


import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.*;
import overclock.overclock.model.Address;

@Getter
@Setter
@ToString
public class AuthMemberDTO extends User {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String curl;
    private boolean auth;

    public AuthMemberDTO(String username, String password, Long id, boolean auth, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        email = username;
        this.password = password;
        this.auth = auth;
    }


}

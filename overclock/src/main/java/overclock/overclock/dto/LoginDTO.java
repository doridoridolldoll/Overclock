package overclock.overclock.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import overclock.overclock.entity.Member;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    private String email;

    private String password;


    public Member toEntity() {

        Member build = Member.builder()
                .email(email)
                .password(password)
                .build();

        return build;
    }

}
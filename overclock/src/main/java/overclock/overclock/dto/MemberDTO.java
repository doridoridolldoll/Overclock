package overclock.overclock.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String nickname;
    private String password;
    private boolean fromSocial;

    private String city;
    private String street;
    private String zipcode;

    @Builder.Default
    private Set<String> roleSet = new HashSet<>();
}

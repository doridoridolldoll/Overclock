package overclock.overclock.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
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
    private String numb;

    private String city;
    private String street;
    private String zipcode;

    private int crn;

    private Long memberId;


    @Builder.Default
    private Set<String> roleSet = new HashSet<>();
}

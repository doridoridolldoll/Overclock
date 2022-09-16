package overclock.overclock.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;

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

    private String city;
    private String street;
    private String zipcode;
}

package overclock.overclock.security.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TokenDTO {

    private Long id;
    private String email;
    private String name;
    private String token;
    private String curl;
    private Boolean fromSocial;
}
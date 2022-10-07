package overclock.overclock.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MailDTO {
    private String address;
    private String title;
    private String message;
    private String email;
    private String tempPass;
    private String key;
}

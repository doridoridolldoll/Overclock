package overclock.overclock.dto;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailFindDTO {

    private String crn;
    private String email;
    private String phone;

}

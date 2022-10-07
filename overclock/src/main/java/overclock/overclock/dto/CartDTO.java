package overclock.overclock.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private Long id;
    private int count;
    private String cartName;
    private int price;
    private String imgUrl;
    private Long MemberId;


}

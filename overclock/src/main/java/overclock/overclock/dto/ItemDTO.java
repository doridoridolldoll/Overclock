package overclock.overclock.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDTO {

    private Long id;
    private String title;
    private String itemName;
    private String itemDetail;
    private int price;
    private int stock;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

    @Builder.Default
    private List<ItemImgDTO> imageDTOList = new ArrayList<>();
}

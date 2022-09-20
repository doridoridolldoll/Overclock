package overclock.overclock.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsDTO {
    private Long id;
    private String title;
    private String content;
    private Long memberId;
    private int viewCount;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    @Builder.Default
    private List<ItemImgDTO> imageDTOList = new ArrayList<>();


}

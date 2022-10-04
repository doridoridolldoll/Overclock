package overclock.overclock.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String partsType;
    private String search;
    @Builder.Default
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<ItemImgDTO> imageDTOList = new ArrayList<>();


}

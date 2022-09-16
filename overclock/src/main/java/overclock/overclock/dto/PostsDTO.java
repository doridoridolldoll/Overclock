package overclock.overclock.dto;

import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime regDate;
    private LocalDateTime modDate;


}

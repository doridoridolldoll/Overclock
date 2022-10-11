package overclock.overclock.dto;

import lombok.*;

import java.time.LocalDateTime;
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private String content;
    private Long memberId;
    private Long postsId;
    private String nickname;
    private LocalDateTime regDate;
    private LocalDateTime modDate;



}

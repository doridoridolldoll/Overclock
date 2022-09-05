package overclock.overclock.entity;

import lombok.*;
import overclock.overclock.model.BoardType;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posts extends BaseEntity{ //게시물

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Enumerated
    private BoardType boardType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private String title; //제목

    private int viewCount; //조회수

    @Column
    private String writer;

    @Embedded
    private Address address; //주소

    @Builder
    public Posts(Member member, String title, String writer,
                int viewCount, BoardType boardType) {
        this.member = member;
        this.title = title;
        this.viewCount = viewCount;
//        this.address = address;
        this.writer = writer;
        this.boardType = boardType;
    }
}

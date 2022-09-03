package overclock.overclock.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posts extends BaseEntity{ //게시물

    @Id
    @Column(name = "posts_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private String title; //제목

    private int viewCount; //조회수

    @Embedded
    private Address address; //주소

    @Builder
    public Posts(Board board, Member member, String title,
                int viewCount, Address address) {
        this.board = board;
        this.member = member;
        this.title = title;
        this.viewCount = viewCount;
        this.address = address;
    }
}

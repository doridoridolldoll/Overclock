package overclock.overclock.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity{ //게시물

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private String id;

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
    public Post(Board board, Member member, String title,
                int viewCount, Address address) {
        this.board = board;
        this.member = member;
        this.title = title;
        this.viewCount = viewCount;
        this.address = address;
    }
}

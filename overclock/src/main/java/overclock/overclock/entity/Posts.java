package overclock.overclock.entity;

import lombok.*;
import overclock.overclock.model.Address;
import overclock.overclock.model.BoardType;
import overclock.overclock.model.PartsType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "member")
@Builder
@AllArgsConstructor

public class Posts extends BaseEntity{ //게시물

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private BoardType boardType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(nullable = false)
    private String title; //제목

    private String content;

    private int viewCount; //조회수

    @Enumerated
    private PartsType partsType;

    @Embedded
    private Address address; //주소



    @Builder
    public Posts(Member member, String title, String content,
                int viewCount, BoardType boardType, Address address) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.address = address;
        this.boardType = boardType;
    }
}

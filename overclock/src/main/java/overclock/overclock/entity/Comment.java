package overclock.overclock.entity;

import lombok.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Posts posts; //글제목

    @ManyToOne
    private Member member; //작성자

    private String content; //내용

    public Comment(Long id, Posts posts, Member member, String content) {
        this.id = id;
        this.posts = posts;
        this.member = member;
        this.content = content;
    }
}

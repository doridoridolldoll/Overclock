package overclock.overclock.service;

import org.springframework.stereotype.Service;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;

public interface PostsService {
    Long register(PostsDTO dto);

    default Posts dtoToEntity(PostsDTO dto){
        Member member = Member.builder()
                .id(dto.getMemberId())
                .build();
        Posts posts = Posts.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .member(member)
                .build();
        return posts;
    }
}


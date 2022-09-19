package overclock.overclock.service;

import org.springframework.stereotype.Service;

import overclock.overclock.dto.PageRequestDTO;
import overclock.overclock.dto.PageResultDTO;

import overclock.overclock.dto.PostsDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;

import java.util.List;

public interface PostsService {
    Long mregister(PostsDTO dto); //중고거래 게시판 글쓰기

    Long pregister(PostsDTO dto); //부품 게시판 글쓰기

    PageResultDTO<PostsDTO, Object[]> getList2(PageRequestDTO requestDTO);

    PageResultDTO<PostsDTO, Posts> getPageList(PageRequestDTO dto);

    PageResultDTO<PostsDTO, Object[]> getList(PageRequestDTO pageRequestDTO); //목록처리
    List<PostsDTO> getList();

    default Posts dtoToEntity(PostsDTO dto) {
        Member member = Member.builder()
                .id(dto.getMemberId())
                .build();
        Posts posts = Posts.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .viewCount(dto.getViewCount())
                .member(member)
                .build();
        return posts;
    }

    default PostsDTO entityToDTO(Posts posts) {
        PostsDTO postsDTO = PostsDTO.builder()
                .id(posts.getId())
                .title(posts.getTitle())
                .content(posts.getContent())
                .regDate(posts.getRegDate())
                .modDate(posts.getModDate())
                .viewCount(posts.getViewCount())
                .memberId(posts.getMember().getId())
                .build();
        return postsDTO;
    }
}


package overclock.overclock.service;


import overclock.overclock.dto.PageRequestDTO;
import overclock.overclock.dto.PageResultDTO;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;

public interface PostsService {
    Long mregister(PostsDTO dto); //중고거래 게시판 글쓰기

    Long pregister(PostsDTO dto); //부품 게시판 글쓰기

    PageResultDTO<PostsDTO, Object[]> getList(PageRequestDTO pageRequestDTO); //목록처리

    PostsDTO get(Long id); //조회처리

    default Posts dtoToEntity(PostsDTO dto) {
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

    default PostsDTO entityToDTO(Posts posts, Member member) {
        PostsDTO postsDTO = PostsDTO.builder()
                .id(posts.getId())
                .title(posts.getTitle())
                .content(posts.getContent())
                .regDate(posts.getRegDate())
                .modDate(posts.getModDate())
                .writerEmail(member.getEmail())
                .writerNickname(member.getNickname())
                .memberId(member.getId())
                .build();
        return postsDTO;
    }
}


package overclock.overclock.service;

import org.springframework.stereotype.Service;

import overclock.overclock.dto.*;

import overclock.overclock.entity.Item;
import overclock.overclock.entity.ItemImg;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface PostsService {
    Long mregister(PostsDTO dto); //중고거래 게시판 글쓰기
    PageResultDTO<PostsDTO, Posts> getPageList(PageRequestDTO dto); //중고거래 게시판 리스트

    Long pregister(PostsDTO dto); //부품 게시판 글쓰기
    PageResultDTO<PostsDTO, Posts> partsPageList(PageRequestDTO dto); //부품 게시판 리스트

    PageResultDTO<PostsDTO, Object[]> getList2(PageRequestDTO requestDTO);

    PageResultDTO<PostsDTO, Posts> partscategeryPageList (PageRequestDTO dto);


    List<PostsDTO> getList(PostsDTO postsDTO);

    default Posts dtoToEntity(PostsDTO dto) {
        Member member = Member.builder()
                .id(dto.getMemberId())
                .build();
        Posts posts = Posts.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .viewCount(dto.getViewCount())
                .partsType(dto.getPartsType())
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
                .partsType(posts.getPartsType())
                .memberId(posts.getMember().getId())
                .imageDTOList(posts.getItemImgList().stream().map(new Function<ItemImg,ItemImgDTO>() {
                    @Override
                    public ItemImgDTO apply(ItemImg t) {
                        ItemImgDTO result = ItemImgDTO.builder()
                                .imgName(t.getImgName())
                                .uuid(t.getUuid())
                                .path(t.getPath())
                                .build();

                        return result;
                    }
                }).collect(Collectors.toList()))
                .build();
        return postsDTO;
    }

    default ItemImg imageDtoToEntity(ItemImgDTO dto, Long id){
        Posts posts = Posts.builder()
                .id(dto.getPostsId())
                .build();
        ItemImg ii = ItemImg.builder()
                .uuid(dto.getUuid())
                .path(dto.getPath())
                .imgName(dto.getImgName())
                .build();
        return ii;
    }

    default ItemImg imageDtoToEntity2(ItemImgDTO dto){
        ItemImg ii = ItemImg.builder()
                .uuid(dto.getUuid())
                .path(dto.getPath())
                .imgName(dto.getImgName())
                .build();
        return ii;
    }
}


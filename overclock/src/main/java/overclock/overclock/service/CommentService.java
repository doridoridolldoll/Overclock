package overclock.overclock.service;

import overclock.overclock.dto.*;
import overclock.overclock.entity.Comment;
import overclock.overclock.entity.ItemImg;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;

import java.util.function.Function;
import java.util.stream.Collectors;

public interface CommentService {
    Long addComment(CommentDTO commentDTO);

    PageResultDTO<CommentDTO, Comment> commentPageList (PageRequestDTO dto);
    default Comment dtoToEntity(CommentDTO dto) {
        Member member = Member.builder()
                .id(dto.getMemberId())
                .build();
        Posts posts = Posts.builder()
                .id(dto.getPostsId())
                .build();
        Comment comment = Comment.builder()
                .id(dto.getId())
                .content(dto.getContent())
                .member(member)
                .posts(posts)
                .build();
        return comment;
    }

    default CommentDTO entityToDTO(Comment comment){
        CommentDTO commentDTO =  CommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .regDate(comment.getRegDate())
                .modDate(comment.getModDate())
                .memberId(comment.getMember().getId())
                .postsId(comment.getPosts().getId())
                .build();

        return commentDTO;
    }

}

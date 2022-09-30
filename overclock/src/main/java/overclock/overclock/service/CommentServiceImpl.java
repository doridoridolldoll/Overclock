package overclock.overclock.service;

import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import overclock.overclock.dto.CommentDTO;
import overclock.overclock.dto.PageRequestDTO;
import overclock.overclock.dto.PageResultDTO;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.entity.Comment;
import overclock.overclock.entity.Member;
import overclock.overclock.repository.CommentRepository;

import javax.transaction.Transactional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
@ToString
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;


    //댓글추가
    @Transactional
    @Override
    public Long addComment(CommentDTO commentDTO) {
        log.info("CommentDTO : {}", commentDTO);

        Comment comment = dtoToEntity(commentDTO);
        commentRepository.save(comment);
        return comment.getId();
    }

    //댓글 리스트
    @Transactional
    @Override
    public PageResultDTO<CommentDTO, Comment> commentPageList(PageRequestDTO dto) {
        log.info("PageRequestDTO: " + dto);
//        log.info("asd: {}", commentDTO);
        Pageable pageable = dto.getPageable(Sort.by("id").descending());
        Page<Comment> result = commentRepository.commentList(dto.getPostsId(), pageable);
        log.info("Comment result : {}", result);
        Function<Comment, CommentDTO> fn = new Function<Comment, CommentDTO>() {
            @Override
            public CommentDTO apply(Comment comment) {
                return entityToDTO(comment);
            }
        };
        return new PageResultDTO<>(result, fn);
    }
}

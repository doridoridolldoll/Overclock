package overclock.overclock.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import overclock.overclock.dto.*;
import overclock.overclock.entity.Comment;
import overclock.overclock.repository.CommentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
@ToString
public class  CommentServiceImpl implements CommentService {

            private final CommentRepository commentRepository;


            //댓글추가
//    @Transactional
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
                        log.info("commnet : {}", comment);
                        return entityToDTO(comment);
            }
                };
            return new PageResultDTO<>(result, fn);
            }
            @Transactional
            @Override
            public String commentName(MemberDTO dto) {
                log.info("Comment Member DTO : {}",dto);
                log.info("MemberId : {}", dto);
//                Long postsId = dto.getPostsId();
//                List<Comment> result = commentRepository.commentName(dto.getMemberId());
//                log.info("memberId : {}", result);

                return null;
            }

            @Transactional
            @Override
            public Long CommentDelete(CommentDTO dto) {
                Long id = dto.getId();
                commentRepository.deleteById(id);
                return id;

            }

            @Override
            public String CommentModify(CommentDTO dto) {
                log.info("dto :" + dto);
                Comment entity = commentRepository.getReferenceById(dto.getId());
                log.info("entity : " + entity);
                CommentDTO getById = entityToDTO(entity);
                log.info("getById : " + getById);

                getById.setContent(dto.getContent());
                Comment modifiedComment = dtoToEntity(getById);
                commentRepository.save(modifiedComment);

                return modifiedComment.getId().toString();
            }
}

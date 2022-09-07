package overclock.overclock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import overclock.overclock.dto.PageRequestDTO;
import overclock.overclock.dto.PageResultDTO;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;
import overclock.overclock.model.BoardType;
import overclock.overclock.repository.PostsRepository;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class PostsServiceImpl implements PostsService {

    private final PostsRepository repository;

    @Override
    public Long mregister(PostsDTO dto) {
        log.info(dto);
        Posts posts = dtoToEntity(dto);
        posts.setBoardType(BoardType.MARKET);
        repository.save(posts);
        return posts.getId();
    }

    @Override
    public Long pregister(PostsDTO dto) {
        log.info(dto);
        Posts posts = dtoToEntity(dto);
        posts.setBoardType(BoardType.PARTS);
        repository.save(posts);
        return posts.getId();
    }

    @Override
    public PageResultDTO<PostsDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);

        Function<Object[], PostsDTO> fn = (en -> entityToDTO((Posts)en[0],(Member) en[1]));
        Page<Object[]> result = repository.getPostsWithMemberPage(pageRequestDTO.getPageable(Sort.by("id").descending()));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public PostsDTO get(Long id) {
        Object result = repository.getPostsById(id);
        Object[] arr = (Object[])result;
        log.info(arr);
        return entityToDTO((Posts)arr[0],(Member)arr[1]);
    }
}

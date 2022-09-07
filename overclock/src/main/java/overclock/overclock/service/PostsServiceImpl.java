package overclock.overclock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.entity.Posts;
import overclock.overclock.model.BoardType;
import overclock.overclock.repository.PostsRepository;

@Service
@RequiredArgsConstructor
@Log4j2
public class PostsServiceImpl implements PostsService {

    private final PostsRepository repository;

    @Override
    public Long register(PostsDTO dto) {
        log.info(dto);
        Posts posts = dtoToEntity(dto);
        repository.save(posts);
        posts.setBoardType(BoardType.SALE);
        return posts.getId();
    }
}

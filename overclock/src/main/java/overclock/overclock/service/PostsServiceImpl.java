
//package overclock.overclock.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Service;
//import overclock.overclock.dto.PostsDTO;
//import overclock.overclock.entity.Posts;
//import overclock.overclock.model.BoardType;
//import overclock.overclock.repository.PostsRepository;
//
//@Service
//@RequiredArgsConstructor
//@Log4j2
//public class PostsServiceImpl implements PostsService {
//
//    private final PostsRepository repository;
//
//    @Override
//    public Long register(PostsDTO dto) {
//        log.info(dto);
//        Posts posts = dtoToEntity(dto);
//        repository.save(posts);
//        posts.setBoardType(BoardType.SALE);
//        return posts.getId();
//    }
//}

package overclock.overclock.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import overclock.overclock.dto.*;
import overclock.overclock.entity.*;
import overclock.overclock.model.BoardType;
import overclock.overclock.model.search;
import overclock.overclock.repository.ItemImgRepository;
import overclock.overclock.repository.PostsRepository;

import javax.transaction.Transactional;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
@ToString
public class PostsServiceImpl implements PostsService {

    private final PostsRepository repository;
    private final ItemImgRepository itemImgRepository;


    @Transactional
    @Override
    public Long mregister(PostsDTO dto) {
        log.info("dto : {}", dto);
        Posts posts = dtoToEntity(dto);
        posts.setBoardType(BoardType.MARKET);

        repository.save(posts);

        List<ItemImgDTO> imgList = dto.getImageDTOList();
        log.info("imgList : {}", imgList);
        imgList.forEach(new Consumer<ItemImgDTO>() {
            @Override
            public void accept(ItemImgDTO itemImgDTO) {
                ItemImg ii = imageDtoToEntity2(itemImgDTO);
                ii.updateItemImg(Posts.builder().id(posts.getId()).build());
                log.info("ItemImg : {}", ii);
                itemImgRepository.save(ii);
            }
        });
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
    public PageResultDTO<PostsDTO, Object[]> getList2(PageRequestDTO requestDTO) {
        log.info("pageRequestDTO : {} ", requestDTO);

        Function<Object[], PostsDTO> fn = (en -> entityToDTO((Posts) en[0]));
        Page<Object[]> result = repository.getPostsWithMemberPage(requestDTO.getPageable(Sort.by("id").descending()));

        return new PageResultDTO<>(result, fn);

    }

//    @Override
//    public List<PostsDTO> getList(PostsDTO postsDTO) {
//        List<Posts> result = repository.findAll();
//        log.info("result : {}", result);
//        return result.stream().map(new Function<Posts, PostsDTO>() {
//            @Override
//            public PostsDTO apply(Posts t) {
//                log.info("asd : {}", entityToDTO(t));
//                return entityToDTO(t);
//            }
//        }).collect(Collectors.toList());
//
//    }

    @Override
    public PageResultDTO<PostsDTO, Posts> getList3(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<Posts> result = repository.findAll(pageable);
        Function<Posts, PostsDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public PageResultDTO<PostsDTO, Posts> getPageList(PageRequestDTO dto) {
        log.info("PageRequestDTO: " + dto);
        Pageable pageable = dto.getPageable(Sort.by("id").descending());

//        Page<Posts> result = repository.getPageList2(pageable);
        Page<Posts> result = repository.getPartsByCategeryPageList(pageable, dto.getCategory());
        log.info("result2 : {}", result);
        Function<Posts, PostsDTO> fn = new Function<Posts, PostsDTO>() {
            @Override
            public PostsDTO apply(Posts t) {
                return entityToDTO(t);
            }
        };
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public PageResultDTO<PostsDTO, Posts> partsPageList(PageRequestDTO dto) {
        log.info("PageRequestDTO: " + dto);

        Pageable pageable = dto.getPageable(Sort.by("id").descending());
        Page<Posts> result = repository.partsCpuPageList(pageable);
        Function<Posts, PostsDTO> fn = new Function<Posts, PostsDTO>() {
            @Override
            public PostsDTO apply(Posts t) {
                log.info("asd : {}", t);
                return entityToDTO(t);
            }
        };
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public PageResultDTO<PostsDTO, Posts> partsCategoryPageList (PageRequestDTO dto){
        log.info("PageRequestDTO: " + dto);
        Pageable pageable = dto.getPageable(Sort.by("id").descending());
        BooleanBuilder booleanBuilder = getSearch(dto);
        Page<Posts> result = repository.getPartsByCategeryPageList(pageable, dto.getCategory());
//        Page<Posts> result2 = repository.findAll(booleanBuilder, pageable);
        Function<Posts, PostsDTO> fn = new Function<Posts, PostsDTO>() {
            @Override
            public PostsDTO apply(Posts t) {
                log.info("asd : {}", t);
                return entityToDTO(t);
            }
        };
        return new PageResultDTO<>(result, fn);
    };


    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        String type = requestDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QPosts qPosts = QPosts.posts;
        String keyword = requestDTO.getKeyword();
        BooleanExpression expression = qPosts.id.gt(0L);
        booleanBuilder.and(expression);

        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        //검색 조건 작성
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if (type.contains("t")) {
            conditionBuilder.or(qPosts.title.contains(keyword));
        }
        if (type.contains("c")) {
            conditionBuilder.or(qPosts.content.contains(keyword));
        }

        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

    @Transactional
    @Override
    public PostsDTO updateView(Long id) {
        log.info("id : {}", id);
        Posts result = repository.getByid(id);
        PostsDTO postsDTO = entityToDTO(result);
        repository.updateView(id);
        return postsDTO;
    }

    @Override
    public HashMap<String, Object> getSearchList(search vo) {
        log.info(vo);

//        Pageable pageable;
//        pageable = PageRequest.of(vo.getReqPage(), 9,Sort.by(Sort.Direction.DESC, "id"));

        Pageable pageable = PageRequest.of(vo.getReqPage(), 9);
        Page<Posts> page = repository.getListAndAuthorByAuthorOrTitlePage(vo.getSearch(), pageable);
        log.info("=====page======");
        log.info(page);
        List<EmbedCard> result = repository.getSearchList2(vo.getSearch()).get().stream().map(v -> {
            return new EmbedCard(v);
        }).collect(Collectors.toList());
        HashMap<String, Object> cardInfo = new HashMap<>();
        cardInfo.put("articles", result);
        cardInfo.put("page", pageable.getPageNumber());
        cardInfo.put("pageTotalCount", page.getTotalPages());
        log.info("===================result===========================");
        log.info(result);
        log.info("===================cardinfo===========================");
        log.info(cardInfo);
        return cardInfo;
    }

    @Override
    public List<Object[]> getSearchPostList(String search) {
        return null;
    }
}






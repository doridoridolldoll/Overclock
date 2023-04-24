
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

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import overclock.overclock.dto.*;
import overclock.overclock.entity.ItemImg;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;
import overclock.overclock.model.BoardType;
import overclock.overclock.model.PartsType;
import overclock.overclock.repository.ItemImgRepository;
import overclock.overclock.repository.PostsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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

    @Override
    public List<PostsDTO> getList(PostsDTO postsDTO) {
        List<Posts> result = repository.findAll();
        log.info("result : {}", result);
        return result.stream().map(new Function<Posts, PostsDTO>() {
            @Override
            public PostsDTO apply(Posts t) {
                log.info("asd : {}", entityToDTO(t));
                return entityToDTO(t);
            }
        }).collect(Collectors.toList());

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
    public PageResultDTO<PostsDTO, Posts> partscategeryPageList (PageRequestDTO dto){
        log.info("PageRequestDTO: " + dto);
        Pageable pageable = dto.getPageable(Sort.by("id").descending());
        Page<Posts> result = repository.getPartsByCategeryPageList(pageable, dto.getCategory());
        Function<Posts, PostsDTO> fn = new Function<Posts, PostsDTO>() {
            @Override
            public PostsDTO apply(Posts t) {
                log.info("asd : {}", t);
                return entityToDTO(t);
            }
        };
        return new PageResultDTO<>(result, fn);
    };

<<<<<<< Updated upstream
=======
    @Transactional
    @Override
    public HashMap<String, Object> periDetail(PostsDTO dto) {
        log.info("peri id : {}", dto);
        Long id = dto.getId();
        List<EmbedCard> result = repository.getPeriByIdPageList(id).get().stream().map(v->{
            return new EmbedCard(v);
        }).collect(Collectors.toList());
        HashMap<String, Object> cardInfo = new HashMap<>();
        cardInfo.put("articles", result);
        log.info("peri result : {}", result);
        return cardInfo;
    }
>>>>>>> Stashed changes


}






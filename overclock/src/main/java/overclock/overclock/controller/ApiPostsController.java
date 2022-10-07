package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import overclock.overclock.dto.*;
import overclock.overclock.service.CartService;
import overclock.overclock.service.ItemService;
import overclock.overclock.service.PostsService;

@RestController
@Log4j2
@RequestMapping("/register")
@RequiredArgsConstructor
public class ApiPostsController {
    private final PostsService postsService;
    private final ItemService itemService;
    private final CartService cartService;
    /**
     * 게시판 등록
     */
    @RequestMapping(value = "/posting", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> register(@RequestBody PostsDTO postsDTO){
        log.info("api/memberRegister...:" + postsDTO);
        Long id = postsService.posting(postsDTO);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    /**
     * 게시판 아이템 등록
     */
    @RequestMapping(value = "/itemPosting", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> register2(@RequestBody ItemDTO itemDTO){
        log.info("/api/ItemPosting Item DTO {}", itemDTO);
        Long id = itemService.itemPosting(itemDTO);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/cartAdd", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> cartAdd(@RequestBody CartDTO dto){
        log.info("cartAdd...:" + dto);
        int id = cartService.cartAdd(dto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}

package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import overclock.overclock.dto.*;
import overclock.overclock.entity.Posts;
import overclock.overclock.service.MemberService;
import overclock.overclock.service.PostsService;

@RestController
@Log4j2
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final PostsService postsService;
    private final MemberService memberService;

    @RequestMapping(value = "/memberRegister", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody MemberDTO dto){
        log.info("asd");
        log.info("api/memberRegister...ClubMemberDTO:" + dto);
        String email = memberService.join(dto);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }
    @RequestMapping(value = "/mregister", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> register(@RequestBody PostsDTO postsDTO, ItemDTO itemDTO){
        log.info("api/memberRegister...ClubMemberDTO:" + postsDTO);
        Long id = postsService.mregister(postsDTO);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @RequestMapping(value = "/getlist", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PostsDTO, Posts>> getList(@RequestBody PageRequestDTO dto) {
        PageResultDTO<PostsDTO,Posts> result = postsService.getPageList(dto);
        log.info("postsDTO : {}", dto);
        log.info("List result : {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/partsList", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PostsDTO, Posts>> partsList(@RequestBody PageRequestDTO dto) {
        PageResultDTO<PostsDTO,Posts> result = postsService.partscategeryPageList(dto);
        log.info("postsDTO : {}", dto);
        log.info("List result : {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-page-list", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PostsDTO, Posts>> getPagingList(@RequestBody PageRequestDTO dto) {
        log.info("PageRequestDTO page: " + dto.getPage());
        return new ResponseEntity<>(postsService.getPageList(dto), HttpStatus.OK);
    }
}

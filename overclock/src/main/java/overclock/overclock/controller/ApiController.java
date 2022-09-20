package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import overclock.overclock.dto.MemberDTO;
import overclock.overclock.dto.PageRequestDTO;
import overclock.overclock.dto.PageResultDTO;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.entity.Posts;
import overclock.overclock.service.ItemService;
import overclock.overclock.service.MemberService;
import overclock.overclock.service.PostsService;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    public final PostsService postsService;
    private final MemberService memberService;

    private final ItemService itemService;

    @RequestMapping(value = "mregister", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> register(@RequestBody PostsDTO postsDTO){
        log.info("api/memberRegister...ClubMemberDTO:" + postsDTO);
        Long id = postsService.mregister(postsDTO);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //멤버 회원가입
    @RequestMapping(value = "/memberRegister", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> register(@RequestBody MemberDTO dto){
        log.info("api/memberRegister...ClubMemberDTO:" + dto);
        Long id = memberService.join(dto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/getlist", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostsDTO>> getList() {
        List<PostsDTO> result = postsService.getList();
        log.info(result);


        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-page-list", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PostsDTO, Posts>> getPagingList(@RequestBody PageRequestDTO dto) {
        log.info("PageRequestDTO page: " + dto.getPage());
        return new ResponseEntity<>(postsService.getPageList(dto), HttpStatus.OK);
    }
}

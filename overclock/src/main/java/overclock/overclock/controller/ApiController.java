package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import overclock.overclock.dto.MemberDTO;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.service.MemberService;
import overclock.overclock.service.PostsService;

@RestController
@Log4j2
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    public final PostsService postsService;
    private final MemberService memberService;

    @RequestMapping(value = "mregister", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> register(@RequestBody PostsDTO postsDTO){
        log.info("api/memberRegister...ClubMemberDTO:" + postsDTO);
        Long id = postsService.mregister(postsDTO);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
//    @RequestMapping(value = "/memberRegister", method = RequestMethod.POST,
//            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> register(@RequestBody MemberDTO dto){
//        log.info("api/memberRegister...ClubMemberDTO:" + dto);
//        String email = memberService.register(dto);
//        return new ResponseEntity<>(email, HttpStatus.OK);
//    }

}

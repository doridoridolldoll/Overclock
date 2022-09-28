package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import overclock.overclock.dto.*;
import overclock.overclock.entity.Posts;
import overclock.overclock.service.MemberService;
import overclock.overclock.service.PostsService;

@RestController
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class ApiMemberController {
    public final PostsService postsService;
    private final MemberService memberService;

//    멤버 회원가입
    @RequestMapping(value = "/memberRegister", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody MemberDTO dto){
        log.info("asd");
        log.info("api/memberRegister...ClubMemberDTO:" + dto);
        String email = memberService.join(dto);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }


}

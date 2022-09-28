package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import overclock.overclock.dto.*;
import overclock.overclock.entity.Posts;
import overclock.overclock.security.dto.AuthMemberDTO;
import overclock.overclock.security.util.JWTUtil;
import overclock.overclock.service.MemberService;
import overclock.overclock.service.PostsService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class ApiMemberController {
    public final PostsService postsService;
    private final MemberService memberService;


    private final JWTUtil jwtUtil;


//    멤버 회원가입
    @RequestMapping(value = "/memberRegister", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody MemberDTO dto){
        String email = memberService.join(dto);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }


    }
//    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<HashMap<String, Object>> ArticleCardsSearch(@RequestBody search vo){
//        log.info(vo);
//        return new ResponseEntity<>(postsService.getSearchList(vo), HttpStatus.OK);

}

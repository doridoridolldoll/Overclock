package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;
import overclock.overclock.domain.PcPayRequest;
import overclock.overclock.dto.*;
import overclock.overclock.entity.Comment;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Posts;
import overclock.overclock.model.search;
import overclock.overclock.model.subcard;
import overclock.overclock.service.*;
import overclock.overclock.vo.passCheck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Log4j2
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final PostsService postsService;
    private final MemberService memberService;
    private final ItemService itemService;
    private final CommentService commentService;
    private final SendEmailService sendEmailService;
    /**
     * 멤버 회원가입
     */
    @RequestMapping(value = "/memberRegister", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody MemberDTO dto){
        log.info("asd");
        log.info("api/memberRegister...:" + dto);
        String email = memberService.memberRegister(dto);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }
    /**
     * 업체 회원가입
     */
//    @RequestMapping(value = "/companyRegister", method = RequestMethod.POST,
//            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> companyRegister(@RequestBody MemberDTO dto){
//        log.info("api/companyRegister...:" + dto);
//        String email = memberService.companyRegister(dto);
//        return new ResponseEntity<>(email, HttpStatus.OK);
//    }

    /**
     * 일반 게시판 목록 처리
     */
    @RequestMapping(value = "/getlist", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PostsDTO, Posts>> getList(@RequestBody PageRequestDTO dto) {
        PageResultDTO<PostsDTO,Posts> result = postsService.getPageList(dto);
        log.info("postsDTO : {}", dto);
        log.info("List result : {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 부품 게시판 목록 처리
     */
    @RequestMapping(value = "/partsList", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PostsDTO, Posts>> partsList(@RequestBody PageRequestDTO dto) {
        PageResultDTO<PostsDTO,Posts> result = postsService.partsCategoryPageList(dto);
        log.info("postsDTO : {}", dto);
        log.info("List result : {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * partsItem price 값 받아옴
     */
    @RequestMapping(value = "/partsItemList", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDTO>> partsItemList(@RequestBody ItemDTO dto) {
        List<ItemDTO> result = itemService.partsItemList(dto);
        log.info("csacacsacsac : {}", dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 주변기기 게시판 출력
     */
    @RequestMapping(value = "/periList", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PostsDTO, Posts>> periList(@RequestBody PageRequestDTO dto) {
        PageResultDTO<PostsDTO,Posts> result = postsService.partsCategoryPageList(dto);
        log.info("postsDTO : {}", dto);
        log.info("List result : {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 부품 상세 게시판
     */
    @RequestMapping(value = "/partsDetail", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PostsDTO, Posts>> mbDetail(@RequestBody PageRequestDTO dto) {
        PageResultDTO<PostsDTO,Posts> result = postsService.getPageList(dto);
        log.info("postsDTO : {}", dto);
        log.info("List result : {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 조회수 처리
     */
    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateView(@ModelAttribute("id") Long id) {
        log.info("asdasd : {}", id);
        PostsDTO postsDTO = postsService.updateView(id);

        return new ResponseEntity<>(postsDTO, HttpStatus.OK);
    }

    /**
     * 검색 처리
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Object>> ArticleCardsSearch(@RequestBody search vo) {
        log.info("------------------------------------search--------------------");
        log.info(vo);
        return new ResponseEntity<>(postsService.getSearchList(vo), HttpStatus.OK);
    }

    /**
     * 댓글 등록
     */
    @RequestMapping(value = "/comment/add", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> comment(@RequestBody CommentDTO dto) {
        log.info("CommentDTO : {}", dto);
        Long commentDTO = commentService.addComment(dto);
        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }

    /**
     * 댓글 목록 처리
     */
    @RequestMapping(value = "/comment/list", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<CommentDTO, Comment>> commentList(@RequestBody PageRequestDTO dto) {
        PageResultDTO<CommentDTO,Comment> result = commentService.commentPageList(dto);
//        log.info("comment Id : {}", commentDTO);
        log.info("PageRequestDTO : {}", dto);
        log.info("Comment List result : {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    /**
     * 글 수정
     */
    @RequestMapping(value = "/modify/send", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> PostsModify(@RequestBody PostsDTO dto) {
        log.info("asasaas :" + dto);
        String articleInfo = postsService.PostsModify(dto);
        return new ResponseEntity<>(articleInfo, HttpStatus.OK);
    }
    
    /**
     * 글 삭제
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> PostsDelete(@RequestBody PostsDTO dto) {
        log.info("ppppppppppppppppp :" + dto);
        Long articleInfo = postsService.PostsDelete(dto);
        return new ResponseEntity<>(articleInfo, HttpStatus.OK);
    }
    @RequestMapping(value = "/cModify/send", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> CommentModify(@RequestBody CommentDTO dto) {
        log.info("asasaas :" + dto);
        String commentInfo = commentService.CommentModify(dto);
        return new ResponseEntity<>(commentInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/cDelete", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> CommentDelete(@RequestBody CommentDTO dto) {
        Long commentInfo = commentService.CommentDelete(dto);
        return new ResponseEntity<>(commentInfo, HttpStatus.OK);
    }


    @RequestMapping(value = "/mModify/send", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> MemberModify(@RequestBody MemberDTO dto) {
        log.info("mModify dto :" + dto);
        String memberInfo = memberService.modify(dto);
        return new ResponseEntity<>(memberInfo, HttpStatus.OK);
    }

    //소셜 로그인 후 회원정보수정
//    @RequestMapping(value = "/modify", method = RequestMethod.POST,
//            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> modify(@RequestBody MemberDTO memberDTO) {
//        String email = memberService.modify(memberDTO);
//        log.info("postsDTO : {}", memberDTO);
//        log.info("List result : {}", email);
//        return new ResponseEntity<>(email, HttpStatus.OK);
//    }


    @RequestMapping(value = "/mList", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional> mList(@RequestBody MemberDTO dto) {
        log.info("asasaas :" + dto);
        Optional email = memberService.mList(dto);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }

//    @RequestMapping(value = "/passFind", method = RequestMethod.POST,
//            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Optional> findEmail(@RequestBody MemberDTO email) {
//        log.info(email);
//        return new ResponseEntity<>(memberService.findByEmail(email),HttpStatus.OK);
//    }

    //회원정보 수정 전 패스워드 검증
//    @RequestMapping(value = "/passcheck", method = RequestMethod.POST,
//            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> passCheck(@RequestBody MemberDTO pass) {
//        log.info(pass);
//        return new ResponseEntity<>(memberService.findPass(pass),HttpStatus.OK);
//    }

    @RequestMapping(value = "/passFind", method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Boolean> pw_find(String email){
        email = "skaduf73@gmail.com";
        log.info("pw_find-----------------" + email);
        Map<String,Boolean> json = new HashMap<>();
        boolean pwFindCheck = memberService.userEmailCheck(email);

        System.out.println(pwFindCheck);
        json.put("check", pwFindCheck);
        return json;
    }

    //등록된 이메일로 임시비밀번호를 발송하고 발송된 임시비밀번호로 사용자의 pw를 변경하는 컨트롤러
    @RequestMapping(value = "/passFind/send", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDTO> sendEmail(@RequestBody MemberDTO memberDTO){

        log.info("sendEmail------------------" + memberDTO.getEmail());
//        email = "skaduf73@gmail.com";
        log.info("sendEmail2------------------" + memberDTO);
        MailDTO dto = sendEmailService.createMailAndChangePassword(memberDTO.getEmail());
        log.info("MailDTO : "+ dto);
        sendEmailService.mailSend(dto);
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }
}

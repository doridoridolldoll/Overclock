//package overclock.overclock.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import overclock.overclock.dto.MemberDTO;
//import overclock.overclock.entity.Member;
//import overclock.overclock.security.dto.AuthMemberDTO;
//import overclock.overclock.service.MemberService;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Controller
//@RequiredArgsConstructor
//public class SecurityController {
//
//    private final MemberService memberService;
//
//    @GetMapping("/user")
//    public String signup(MemberDTO memberDTO) {
//        memberService.saveMember(Member.createMember(memberDTO));
//        return "redirect:/login";
//    }
//
//    @GetMapping(value = "/logout")
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
//        return "redirect:/login";
//    }
//
//    @GetMapping("/admin")
//    public @ResponseBody String admin() {
//        return "admin";
//    }
//
//    @GetMapping("/loginForm")
//    public String loginForm() {
//        return "loginForm";
//    }
//
//    @GetMapping("/joinForm")
//    public String joinForm() {
//        return "joinForm";
//    }
//
//    @GetMapping("/join")
//    public @ResponseBody String join() {
//        return "join";
//    }
//    @GetMapping("/joinProc")
//    public @ResponseBody String joinProc() {
//        return "회원가입 완료됨!";
//    }
////    @PostMapping("/signup")
////    public ResponseEntity<String> signUp(@RequestBody UserSignUpRequestDto requestDto){
////        userService.signUp(requestDto.toEntity());
////        return ResponseEntity.ok("User signUp successfully!");
////    }
////
////    @PostMapping("/signin")
////    public ResponseEntity<String> signIn(@RequestBody UserSignInRequestDto requestDto) {
////        return ResponseEntity.ok(userService.signIn(requestDto.toEntity()));
////    }
//}

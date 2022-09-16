package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import overclock.overclock.dto.JoinFormDTO;
import overclock.overclock.dto.MemberDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.model.Address;
import overclock.overclock.service.MemberService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        return "members/memberList";
    }


    //회원가입 페이지
    @GetMapping("/members/new")
    public void join() {
        log.info("asdasdasd");
    }

    @PostMapping("/members/new")
    public String join(MemberDTO memberDTO, Model model) {
        log.info("asd");
        log.info("asd : "+ memberDTO);

            Member member = Member.createMember(memberDTO);
        model.addAttribute("msg", member);
            memberService.join(memberDTO);

        return "redirect:/members/memberList";
    }

}

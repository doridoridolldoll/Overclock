package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.service.PostsService;

@Controller
@RequestMapping("/posts")
@Log4j2
@RequiredArgsConstructor
public class BoardController {
    private final PostsService postsService;

    @GetMapping("/register")
    public void register(){
        log.info("register get...");
    }
    @PostMapping("/register")
    public String registerPost(PostsDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto... {}", dto);

        Long id = postsService.register(dto);
        log.info("id {}", id);

        redirectAttributes.addFlashAttribute("msg", id);

        return "redirect:/posts/register";
    }
}

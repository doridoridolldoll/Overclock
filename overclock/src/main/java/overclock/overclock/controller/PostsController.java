package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import overclock.overclock.dto.ItemDTO;
import overclock.overclock.dto.PageRequestDTO;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.service.ItemService;
import overclock.overclock.service.PostsService;

@Controller
@RequestMapping("/posts")
@Log4j2
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;
    private final ItemService itemService;


    //중고거래 컨트롤러
    @GetMapping("/mregister")
    public void register(){
        log.info("register get...");
    }

    @PostMapping("/mregister")
    public String register(ItemDTO itemDTO, PostsDTO dto, RedirectAttributes redirectAttributes){
        log.info("itemDTO : " + itemDTO);

        Long ino = itemService.register(itemDTO);
        redirectAttributes.addFlashAttribute("msg", ino);

        Long id = postsService.mregister(dto);
        redirectAttributes.addFlashAttribute("msg2", id);


        return "redirect:/posts/list";
    }


    //부품게시판 컨트롤러
//    @GetMapping("/pregister")
//    public void pregister(){
//        log.info("register get...");
//    }
//    @PostMapping("/pregister")
//    public String pregisterPost(PostsDTO dto, RedirectAttributes redirectAttributes) {
//        log.info("dto... {}", dto);
//
//        Long id = postsService.pregister(dto);
//        log.info("id {}", id);
//
//        redirectAttributes.addFlashAttribute("msg", id);
//
//        return "redirect:/posts/pregister";
//    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list.... {} ", pageRequestDTO);
        model.addAttribute("result", postsService.getList(pageRequestDTO));
        model.addAttribute("result", itemService.getList2(pageRequestDTO));
    }
}

package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import overclock.overclock.dto.ItemDTO;
import overclock.overclock.dto.MemberDTO;
import overclock.overclock.dto.OrderDTO;
import overclock.overclock.entity.Item;
import overclock.overclock.entity.Member;
import overclock.overclock.entity.Order;
import overclock.overclock.repository.ItemRepository;
import overclock.overclock.repository.MemberRepository;
import overclock.overclock.service.ItemService;
import overclock.overclock.service.MemberService;
import overclock.overclock.service.OrderService;
//import overclock.overclock.service.OrderService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("order")
@Log4j2
public class OrderController {

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping(value = "/orderForm")
    public String createForm(Model model) {

        List<Member> members = memberService.findMember();
        List<Item> items = itemService.findItem();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping(value = "/orderForm")
    public String order(OrderDTO orderDTO, MemberDTO memberDTO, int count, RedirectAttributes redirectAttributes) {

        Long order = orderService.order(orderDTO, orderDTO.getItemId(), count);
        log.info(order);
        redirectAttributes.addFlashAttribute("msg", order);
        return "redirect:/orderList";
    }

}

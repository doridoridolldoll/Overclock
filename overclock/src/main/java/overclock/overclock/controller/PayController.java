package overclock.overclock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import overclock.overclock.domain.PcPayRequest;
import overclock.overclock.domain.PcPayReturn;
import overclock.overclock.service.PayService;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class PayController {

    private final PayService payService;

    @PostMapping("/PcPay")
    public String PayRequest(Model model, PcPayRequest pcPayRequest) {
        payService.saveOrder(pcPayRequest.getOid(), pcPayRequest.getTimestamp(), pcPayRequest.getSignature(), pcPayRequest.getPrice());
        model.addAttribute("pay", pcPayRequest);
        return "index";
    }

    @GetMapping("/close")
    public String PcClose() {
        return "close";
    }

    @PostMapping("/return")
    public String pcReturn(PcPayReturn pcPayReturn) throws IllegalAccessException, IOException, InterruptedException {
        payService.checkPcReturn(pcPayReturn.getResultCode(), pcPayReturn.getResultMsg(), pcPayReturn.getMid(), pcPayReturn.getOrderNumber(), pcPayReturn.getAuthToken(), pcPayReturn.getAuthUrl(), pcPayReturn.getNetCancelUrl(), pcPayReturn.getCharset(), pcPayReturn.getMerchantData());

        return "redirect:http://localhost:8080/api/PayComplete";
    }
}

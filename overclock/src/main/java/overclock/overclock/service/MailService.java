package overclock.overclock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MailService {

    private JavaMailSender javaMailSender;

    public void sendMail() {
        ArrayList<String> toUserList = new ArrayList<>();

        toUserList.add("bluestar1012@naver.com");

        int toUserSize = toUserList.size();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));

        simpleMailMessage.setSubject("overclock test");

        simpleMailMessage.setText("overclock");
        javaMailSender.send(simpleMailMessage);
    }
}

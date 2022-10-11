package overclock.overclock.service;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import overclock.overclock.dto.EmailFindDTO;
import overclock.overclock.dto.MailDTO;
import overclock.overclock.dto.MemberDTO;
import overclock.overclock.entity.Member;
import overclock.overclock.repository.MemberRepository;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
@ToString
public class SendEmailServiceimpl implements SendEmailService {

    private final MemberRepository memberRepository;

    private final JavaMailSender mailSender;

    public MailDTO createMailAndChangePassword(String email){
        String str = getTempPassword(); //임시번호생성
        MailDTO dto = new MailDTO();

        log.info("MailDTOqwqw : " + email);
        dto.setAddress(email);
        dto.setTitle(email+"님의 OVERCLOCK 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. OVERCLOCK 임시비밀번호 안내 관련 이메일 입니다." + "[" + email + "]" +"님의 임시 비밀번호는 "
                + str + " 입니다.");
        dto.setTempPass(str);
        return dto;
    }
    public MailDTO createMail(String email){
        String str = getTempPassword(); //임시번호생성
        MailDTO dto = new MailDTO();

        dto.setAddress(email);
        dto.setTitle(email+"님의 OVERCLOCK 인증번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. OVERCLOCK 인증번호 안내 관련 이메일 입니다." + "[" + email + "]" +"님의 인증번호는 "
                + str + " 입니다.");
        dto.setKey(str);
        return dto;
    }

    public String getTempPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        log.info("str : {}", str);
        return str;
    }

    public String mailSend(MailDTO dto){
        log.info("MailaASDFASD : " + dto.getAddress());
        System.out.println("이메일 전송 완료!");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getAddress());
        log.info("asdqweasd : " + message.getTo());
        message.setFrom(SendEmailService.FROM_ADDRESS);
        message.setSubject(dto.getTitle());
        message.setText(dto.getMessage());

        mailSender.send(message);
        return dto.getMessage();
    }

    public EmailFindDTO certifiedPhoneNumber(String phone) {
        log.info("phone213 : {} ", phone);
        Member email = memberRepository.findByPhone(phone);
        log.info("email : " + email);
        String api_key = "NCSQAR06FKVVJUEB";
        String api_secret = "T2KMTAFJK7RWEPJDYD05VOMWJGZGSB5W";
        Message coolsms = new Message(api_key, api_secret);

        String str = getTempPassword(); //임시번호생성

        EmailFindDTO emailFindDTO = new EmailFindDTO();
        emailFindDTO.setCrn(str);
        emailFindDTO.setEmail(String.valueOf(email.getEmail()));
        log.info("emailFindDTO : {} ", emailFindDTO);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phone);    // 수신전화번호
        params.put("from", "01080094125");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
        params.put("type", "SMS");
        params.put("text", "OVERCLOCK 휴대폰인증 테스트 메시지 : 인증번호는" + "["+str+"]" + "입니다.");
        params.put("app_version", "test app 1.2"); // application name and version

        log.info("params {} ", params);

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
        return emailFindDTO;
    }
}

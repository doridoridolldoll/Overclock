package overclock.overclock.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import overclock.overclock.dto.MailDTO;
import overclock.overclock.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Log4j2
public class SendEmailServiceimpl implements SendEmailService {

    private final MemberRepository memberRepository;

    private final JavaMailSender mailSender;
    private final PasswordEncoder encoder;

    public MailDTO createMailAndChangePassword(String email){
        String str = getTempPassword(); //임시번호생성
        MailDTO dto = new MailDTO();
        log.info("MailDTOqwqw : " + email);
        dto.setAddress(email);
        dto.setTitle(email+"님의 OVERCLOCK 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. OVERCLOCK 임시비밀번호 안내 관련 이메일 입니다." + "[" + email + "]" +"님의 임시 비밀번호는 "
                + str + " 입니다.");
        updatePassword(str,email);
        return dto;
    }

    public String updatePassword(String str,String email){

        log.info("str : " + str);
        log.info("email : " + email);
//        Long id = memberRepository.findUserById(email).get().getId();
//        log.info("id : " + id);
        log.info("password : " + str);

//        memberRepository.updateUserPassword(em,str);

        return str;
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
        return str;
    }

    public String mailSend(MailDTO dto){
        log.info("MailaASDFASD : " + dto.getAddress());
        System.out.println("이멜 전송 완료!");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getAddress());
        log.info("asdqweasd : " + message.getTo());
        message.setFrom(SendEmailService.FROM_ADDRESS);
        message.setSubject(dto.getTitle());
        message.setText(dto.getMessage());

        mailSender.send(message);
        return dto.getMessage();
    }
}

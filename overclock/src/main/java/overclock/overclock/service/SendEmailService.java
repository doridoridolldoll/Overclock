package overclock.overclock.service;

import overclock.overclock.dto.MailDTO;

public interface SendEmailService {

     static final String FROM_ADDRESS = "bluestar181818@gmail.com";
     MailDTO createMailAndChangePassword(String email);
//     void updatePassword(String str,String email);
     String  mailSend(MailDTO dto);
     MailDTO createMail(String email);

}

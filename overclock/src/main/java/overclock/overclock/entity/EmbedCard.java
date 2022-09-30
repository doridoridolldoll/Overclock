package overclock.overclock.entity;

import lombok.Data;
import overclock.overclock.repository.PostsRepository;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

@Data
public class EmbedCard {
    private Long id;
    private String title;
    private String content;
    private String nickname;

    public EmbedCard(PostsRepository.getEmbedCardsInformation em){
        this.id= em.getId();
        this.title = em.getTitle();
        this.content = em.getContent();
        this.nickname = em.getNickname();
    }

//    public String updateContextToString(byte[] content){
//        String result = new String(content, Charset.forName("utf-8"));
//        return result;
//    }

}

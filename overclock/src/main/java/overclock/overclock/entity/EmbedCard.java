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

    public EmbedCard(PostsRepository.getEmbedCardsInformation em){
        this.id= em.getId();
        this.title = em.getTitle();
        this.content = updateContextToString(em.getContent());
    }

    public String updateContextToString(byte[] context){
        String result = new String(context, Charset.forName("utf-8"));
        return result;
    }

}

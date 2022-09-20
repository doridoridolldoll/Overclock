package overclock.overclock.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_img_id")
    private Long id;

    @Column
    private String imgName;

    @Column
    private String uuid;

    @Column
    private String path;

    @ManyToOne
    private Posts ItemImg;

    public void updateItemImg(Posts id){
        this.ItemImg = id;
    }
}

package overclock.overclock.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "ItemImg")
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

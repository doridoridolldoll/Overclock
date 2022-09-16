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
//@ToString(exclude = "item")
public class ItemImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_img_id")
    private Long id;

    @Column
    private String imgName;

    @Column
    private String uuid;

    @Column
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

}

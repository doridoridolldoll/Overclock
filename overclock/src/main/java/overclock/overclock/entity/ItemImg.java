package overclock.overclock.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemImg extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_img_id")
    private Long id;

    //이미지 원본 이름
    @Column(name = "item_img_name")
    private String oriImgName;

    //이미지 경로
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public ItemImg(String oriImgName, String imgUrl, Item item) {
        this.oriImgName = oriImgName;
        this.imgUrl = imgUrl;
        this.item = item;
    }
}

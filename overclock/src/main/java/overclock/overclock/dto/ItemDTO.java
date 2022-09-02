package overclock.overclock.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private Long id;
    private String itemName;
    private String itemDetail;
    private String imgUrl;
    private Integer price;

//    @QueryProjection // QueryDSL 어노테이션 추가
    public void MainItemDto(Long id, String itemName, String itemDetail,
                       String imgUrl, Integer price){
        this.id = id;
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.imgUrl = imgUrl;
        this.price = price;
    }
}

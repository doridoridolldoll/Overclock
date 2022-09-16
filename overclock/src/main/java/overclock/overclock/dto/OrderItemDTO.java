package overclock.overclock.dto;

import lombok.Getter;
import lombok.Setter;
import overclock.overclock.entity.OrderItem;

@Getter
@Setter
public class OrderItemDTO {

    private String itemName;
    private int count;
    private int orderPrice;
    private String imgUrl;

    public void OrderItemDto(OrderItem orderItem, String imgUrl) {
        this.count = orderItem.getCount();
        this.orderPrice = orderItem.getOrderPrice();
        this.imgUrl = imgUrl;
    }
}

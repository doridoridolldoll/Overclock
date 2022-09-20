package overclock.overclock.dto;

import lombok.*;
import overclock.overclock.entity.OrderItem;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDTO {

    private String itemDetail;
    private int count;
    private int orderPrice;

    public void OrderItemDTO(OrderItem orderItem, String itemDetail) {
        this.itemDetail = itemDetail;
        this.count = orderItem.getCount();
        this.orderPrice = orderItem.getOrderPrice();

    }
}

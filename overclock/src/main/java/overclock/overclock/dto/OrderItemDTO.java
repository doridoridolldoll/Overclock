package overclock.overclock.dto;

import lombok.*;
import overclock.overclock.entity.OrderItem;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDTO {

    private String itemName;
    private int count;
    private int orderPrice;

    public void OrderItemDto(OrderItem orderItem, String itemName) {
        this.itemName = itemName;
        this.count = orderItem.getCount();
        this.orderPrice = orderItem.getOrderPrice();

    }
}

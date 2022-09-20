package overclock.overclock.service;

import overclock.overclock.dto.OrderDTO;
import overclock.overclock.dto.OrderItemDTO;
import overclock.overclock.entity.*;
import overclock.overclock.model.OrderStatus;

import java.util.List;
import java.util.stream.Collectors;

public interface OrderService {

    Long order(Long memberId, Long itemId, int count);

//    void cancelOrder(Long orderId);

    default Order dtoToEntity(OrderDTO orderDTO) {

        Member member = Member.builder()
                .id(orderDTO.getMemberId())
                .build();

        Order order = Order.builder()
                .id(orderDTO.getItemId())
                .orderStatus(OrderStatus.ORDER)
                .member(member)
                .build();

        return order;
    }

    default OrderDTO entityToDTO(Order order, List<OrderItem> orderItems) {
        OrderDTO orderDTO = OrderDTO.builder()
                .itemId(order.getId())
                .build();

        List<OrderItemDTO> orderItemDTOList = orderItems.stream().map(orderItem -> {
            return OrderItemDTO.builder()
                    .orderPrice(orderItem.getOrderPrice())
                    .count(orderItem.getCount())
                    .build();
        }).collect(Collectors.toList());


        return orderDTO;
    }
}


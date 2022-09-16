//package overclock.overclock.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import overclock.overclock.dto.OrderDTO;
//import overclock.overclock.dto.OrderItemDTO;
//import overclock.overclock.entity.*;
//import overclock.overclock.model.DeliveryStatus;
//import overclock.overclock.repository.ItemRepository;
//import overclock.overclock.repository.MemberRepository;
//import overclock.overclock.repository.OrderRepository;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public interface OrderService {
//
//    Long order(OrderDTO orderDTO);
//
//    void cancelOrder(Long orderId);
//
//    default Order dtoToEntity(OrderDTO orderDTO) {
//
//        Order order = Order.builder()
//                .id(orderDTO.getItemId())
//                .build();
//        return order;
//    }
//
//    default OrderDTO entityToDTO(Order order, List<OrderItem> orderItems) {
//        OrderDTO orderDTO = OrderDTO.builder()
//                .itemId(order.getId())
//                .build();
//
//        List<OrderItemDTO> orderItemDTOList = orderItems.stream().map(orderItem -> {
//            return OrderItemDTO.builder()
//                    .orderPrice(orderItem.getOrderPrice())
//                    .count(orderItem.getCount())
//                    .build();
//        }).collect(Collectors.toList());
//
//
//        return orderDTO;
//    }
//}
//

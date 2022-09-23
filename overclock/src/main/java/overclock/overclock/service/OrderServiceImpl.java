//package overclock.overclock.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import overclock.overclock.dto.OrderDTO;
//import overclock.overclock.entity.*;
//import overclock.overclock.model.DeliveryStatus;
//import overclock.overclock.repository.MemberRepository;
//import overclock.overclock.repository.OrderRepository;
//
//@Service
//@RequiredArgsConstructor
//public class OrderServiceImpl implements OrderService{
//
//    private final MemberRepository memberRepository;
//    private final OrderRepository orderRepository;
//
//    @Transactional
//    public Long order(String email, int count, OrderDTO orderDTO) {
//
//        //엔티티 조회
//        Member member = memberRepository.findByEmail(email);
//        Item item = itemRepository.findById(orderDTO.getItemId()).orElseThrow();
//
//        //배송정보 생성
//        Delivery delivery = new Delivery();
//        delivery.setAddress(member.getAddress());
//        delivery.setStatus(DeliveryStatus.READY);
//
//        //주문상품 생성
//        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
//
//        //주문 생성
//        Order order = Order.createOrder(member, delivery, orderItem);
//
//        //주문 저장
//        orderRepository.save(order);
//        return order.getId();
//
//    }
//    /**
//     * 주문 취소
//     */
//    @Transactional
//    public void cancelOrder(Long orderId) {
//
//        //주문 엔티티 조회
//        Order order = orderRepository.findById(orderId).orElseThrow();
//        //주문 취소
//        order.cancel();
//    }
//
//}

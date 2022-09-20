package overclock.overclock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.dto.OrderDTO;
import overclock.overclock.entity.*;
import overclock.overclock.model.DeliveryStatus;
import overclock.overclock.repository.ItemRepository;
import overclock.overclock.repository.MemberRepository;
import overclock.overclock.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }

//        List<OrderItem> orderItemList = new ArrayList<>();
//        Item item = itemRepository.findById(orderDTO.getItemId()).orElseThrow(EntityNotFoundException::new);
//        orderItemList.add(OrderItem.createOrderItem(item, orderDTO.getCount()));
//
//        // Order 객체 생성
//        Member member = memberRepository.findByEmail(email);
//        Order order = Order.createOrder(member, orderItemList);
//
//        // Order 객체 DB 저장 (Cascade로 인해 OrderItem 객체도 같이 저장)
//        orderRepository.save(order);
//        return order.getId();

    }
//        Member member = (Member) memberRepository.findByName(name);
//        Optional<Item> item = itemRepository.findById(itemId);
//
//        Delivery delivery = new Delivery();
//        delivery.setAddress(member.getAddress());
//        delivery.setStatus(DeliveryStatus.READY);
//
//        OrderItem orderItem = OrderItem.createOrderItem(item, count);
//
////        주문 생성
//        Order order = Order.createOrder(member, delivery, orderItem);
//
////        주문 저장
//        orderRepository.save(order);
//        return order.getId();

//        List<OrderItem> orderItemList = new ArrayList<>();
//        for (OrderDTO orderDTO : orderDTOList) {
//            Item item = itemRepository.findById(orderDTO.getItemId()).orElseThrow(EntityNotFoundException::new);
//            OrderItem orderItem = OrderItem.createOrderItem(item, orderDTO.getCount());
//            orderItemList.add(orderItem);
//        }
//
//        //Order Entity 클래스에 존재하는 createOrder 메소드로 Order 생성 및 저장
//        Order order = Order.createOrder(member, orderItemList);
//        orderRepository.save(order);
//        return order.getId();



//        Order order = dtoToEntity(orderDTO);
//        order.setDelivery(order.getDelivery());
//        orderRepository.save(order);
//        return order.getId();
//    }
//
//    @Override
//    public void cancelOrder(Long orderId) {
//
//    }
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
    /**
     * 주문 취소
     */
//    @Transactional
//    public void cancelOrder(Long orderId) {
//
//        //주문 엔티티 조회
//        Order order = orderRepository.findById(orderId).orElseThrow();
//        //주문 취소
//        order.cancel();
//    }



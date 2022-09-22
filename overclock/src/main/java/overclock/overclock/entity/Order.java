package overclock.overclock.entity;

import lombok.*;
import overclock.overclock.model.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 주문 회원

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery; // 배송정보

    private LocalDateTime orderDate; // 주문날짜

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 주문상태 [ORDER, CANCEL]

    @Builder
    public Order(Long id, Member member, List<OrderItem> orderItem,
                 OrderStatus orderStatus, LocalDateTime orderDate) {
        this.id = id;
        this.member = member;
        this.orderItems = orderItem;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {

        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }

        order.setOrderStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

//    public static Order createOrder(Member member, List<OrderItem> orderItemList) {
//
//        Order order = new Order();
//        order.setMember(member);
//        for (OrderItem orderItem : orderItemList) {
//            order.addOrderItem(orderItem);
//        }
//        order.setOrderDate(LocalDateTime.now());
//        order.setOrderStatus(OrderStatus.ORDER);
//        return order;
//    }

}
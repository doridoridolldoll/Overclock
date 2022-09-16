package overclock.overclock.entity;

import lombok.*;
import overclock.overclock.model.Address;
import overclock.overclock.model.DeliveryStatus;
import overclock.overclock.model.MemberRole;
import overclock.overclock.model.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 주문 회원

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "delivery_id")
//    private Delivery delivery; // 배송정보

    private LocalDateTime orderDate; // 주문날짜

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태 [ORDER, CANCEL]

    @Builder
    public Order(Long id, Member member, Delivery delivery, List<OrderItem> orderItem,
                 OrderStatus orderStatus, LocalDateTime orderDate) {
        this.id = id;
        this.member = member;
//        this.delivery = delivery;
        this.orderItems = orderItem;
//        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }


}
package overclock.overclock.entity;

import lombok.Getter;
import lombok.Setter;
import overclock.overclock.model.DeliveryStatus;

import javax.persistence.*;
@Entity
@Getter @Setter
public class Delivery extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //ENUM [READY(준비), COMP(배송)]
}
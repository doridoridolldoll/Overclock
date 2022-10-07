package overclock.overclock.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Cart extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
    private String cartName;
    private int price;
    private String imgUrl;
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

}

package overclock.overclock.entity;

import lombok.*;
import overclock.overclock.exception.OutOfStockException;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Item extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @Column(nullable = false)
    private String itemDetail;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stock;
    // 상품 등록
    public void updateItem(Item item) {
        this.itemDetail = item.getItemDetail();
        this.price = item.getPrice();
        this.stock = item.getStock();
    }

    // 재고수량 증가
    public void addStock(int stock) {
        this.stock += stock;
    }

    // 재고수량 감소
    public void removeStock(int stock) {

        int restStock = this.stock - stock;
        if (restStock < 0) {
            throw new OutOfStockException("상품의 재고가 부족합니다. (현재 재고 수량: " + this.stock + ")");
        }
        this.stock = restStock;
    }
}

package overclock.overclock.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import overclock.overclock.dto.ItemFormDTO;
import overclock.overclock.exception.OutOfStockException;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stock;

    @Builder
    public Item(String itemName, int price, int stock) {
        this.itemName = itemName;
        this.price = price;
        this.stock = stock;
    }

    // 상품 등록
    public void updateItem(ItemFormDTO itemFormDto) {
        this.itemName = itemFormDto.getItemName();
        this.price = itemFormDto.getPrice();
        this.stock = itemFormDto.getStock();
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

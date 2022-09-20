package overclock.overclock.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.repository.ItemRepository;

@SpringBootTest
public class ItemTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품생성() {
        Item item = Item.builder()
                .stock(1)
                .price(1)
                .itemDetail("as")
                .build();
        itemRepository.save(item);
    }
}

//package overclock.overclock.service;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import overclock.overclock.entity.Item;
//import overclock.overclock.repository.ItemRepository;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//
//public class ItemServiceTests {
//
//    ItemService itemService = new ItemService();
//
//    @AfterEach
//    void afterEach() {
//        itemService.clearStore();
//    }
//
//    @Test
//    void save() {
//        //given
//        Item item = new Item("itemA", 10000, 10);
//        //when
//        Item savedItem = itemService.save(item);
//        //then
//        Item findItem = itemService.findById(item.getId());
//        assertThat(findItem).isEqualTo(savedItem);
//    }
//
//    @Test
//    void findAll() {
//        //given
//        Item item1 = new Item("item1", 10000, 10);
//        Item item2 = new Item("item2", 20000, 20);
//
//        itemService.save(item1);
//        itemService.save(item2);
//
//        //when
//        List<Item> result = itemService.findAll();
//
//        //then
//        assertThat(result.size()).isEqualTo(2);
//        assertThat(result).contains(item1, item2);
//    }
//
//    @Test
//    void updateItem() {
//        //given
//        Item item = new Item("item1", 10000, 10);
//
//        Item savedItem = itemService.save(item);
//        Long itemId = savedItem.getId();
//
//        //when
//        Item updateParam = new Item("item2", 20000, 30);
//        itemService.update(itemId, updateParam);
//
//        Item findItem = itemService.findById(itemId);
//
//        //then
//        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
//        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
//        assertThat(findItem.getStock()).isEqualTo(updateParam.getStock());
//    }
//}

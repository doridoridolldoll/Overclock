// package overclock.overclock.entity;
//
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import overclock.overclock.entity.Item;
// import overclock.overclock.entity.Member;
// import overclock.overclock.entity.Order;
// import overclock.overclock.repository.ItemRepository;
// import overclock.overclock.repository.OrderRepository;
//
//
// @SpringBootTest
// public class OrderTests {
//
//     @Autowired
//     ItemRepository itemRepository;
//     @Autowired
//     OrderRepository orderRepository;
//
//
//
//     @Test
//     public void 주문생성() {
//         Member member = Member.builder().email("as").id(1L).build();
//         Delivery delivery = new Delivery();
//         Item item = new Item(1L,"as",1,1);
//         itemRepository.save(item);
//
//         Order order = Order.createOrder(member, delivery, );
//         orderRepository.save(order);
//
//
//     }
// }

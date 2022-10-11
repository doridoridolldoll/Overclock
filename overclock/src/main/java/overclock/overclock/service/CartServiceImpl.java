package overclock.overclock.service;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import overclock.overclock.dto.CartDTO;
import overclock.overclock.dto.PageRequestDTO;
import overclock.overclock.dto.PageResultDTO;
import overclock.overclock.entity.Cart;
import overclock.overclock.entity.Posts;
import overclock.overclock.repository.CartRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
@ToString
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;

    @Transactional
    @Override
    public int cartAdd(CartDTO cartDTO) {
        log.info("cartDTO: {}", cartDTO);
        Cart cart = dtoToEntity(cartDTO);
        cartRepository.save(cart);
        return cart.getCount();
    }


    @Override
    public PageResultDTO<CartDTO, Cart> cartList(PageRequestDTO dto) {
        log.info("PageResultDTO : {}", dto);
        Pageable pageable = dto.getPageable(Sort.by("id").descending());
        Page<Cart> result = cartRepository.getCartList(pageable, dto.getMemberId());
        Function<Cart, CartDTO> fn = new Function<Cart, CartDTO>() {
            @Override
            public CartDTO apply(Cart cart) {
                log.info("cart : {}", cart);
                return entityToDTO(cart);
            }
        };
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public int delete(int a) {

        cartRepository.deleteById((long) a);
        return a;
    }
}

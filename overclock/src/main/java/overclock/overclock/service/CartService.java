package overclock.overclock.service;

import overclock.overclock.dto.*;
import overclock.overclock.entity.*;

import java.util.function.Function;
import java.util.stream.Collectors;

public interface CartService {

    int cartAdd(CartDTO cartDTO);

    PageResultDTO<CartDTO, Cart> cartList (PageRequestDTO dto); //부품,주변기기 게시판 리스트

    default Cart dtoToEntity(CartDTO dto) {

        Member member = Member.builder()
                .id(dto.getMemberId())
                .build();
        Cart cart = Cart.builder()
                .id(dto.getId())
                .count(dto.getCount())
                .price(dto.getPrice())
                .imgUrl(dto.getImgUrl())
                .member(member)
                .cartName(dto.getCartName())
                .build();

        return cart;
    }

    default CartDTO entityToDTO(Cart cart) {
        CartDTO cartDTO = CartDTO.builder()
                .id(cart.getId())
                .count(cart.getCount())
                .imgUrl(cart.getImgUrl())
                .price(cart.getPrice())
                .cartName(cart.getCartName())
                .build();
        return cartDTO;
    }
}

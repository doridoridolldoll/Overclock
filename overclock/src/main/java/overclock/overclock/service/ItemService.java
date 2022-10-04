package overclock.overclock.service;

import overclock.overclock.dto.*;
import overclock.overclock.entity.Item;
import overclock.overclock.entity.ItemImg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ItemService {

    Long mregister2(ItemDTO itemDTO);

    List<ItemDTO> partsItemList(ItemDTO itemDTO);

    default Item dtoToEntity(ItemDTO dto){
        Item item = Item.builder()
                .id(dto.getId())
                .price(dto.getPrice())
                .itemDetail(dto.getItemDetail())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();
        return item;
    }
    default ItemDTO entityToDTO(Item item){
        ItemDTO itemDTO = ItemDTO.builder()
                .id(item.getId())
                .itemDetail(item.getItemDetail())
                .price(item.getPrice())
                .stock(item.getStock())
                .regDate(item.getRegDate())
                .modDate(item.getModDate())
                .build();
        return itemDTO;
    }
}

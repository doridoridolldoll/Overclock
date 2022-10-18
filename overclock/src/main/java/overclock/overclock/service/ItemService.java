package overclock.overclock.service;

import overclock.overclock.dto.*;
import overclock.overclock.entity.Item;
import overclock.overclock.entity.Posts;

import java.util.List;

public interface ItemService {

    Long itemPosting(ItemDTO itemDTO);

    List<Integer> partsItemList(PostsDTO postsDTO);


    default Item dtoToEntity(ItemDTO dto){
        Posts posts = Posts.builder()
                .id(dto.getPostsId())
                .build();
        Item item = Item.builder()
                .id(dto.getId())
                .price(dto.getPrice())
                .itemDetail(dto.getItemDetail())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .posts2(posts)
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
                .postsId(item.getPosts2().getId())
                .build();
        return itemDTO;
    }
}

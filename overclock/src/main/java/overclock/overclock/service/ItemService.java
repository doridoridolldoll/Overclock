package overclock.overclock.service;

import overclock.overclock.dto.*;
import overclock.overclock.entity.Item;
import overclock.overclock.entity.ItemImg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ItemService {

    Long register(ItemDTO itemDTO);

    List<Item> findItem();

//    PageResultDTO<MovieDTO, Object[]> getList(PageRequestDTO requestDTO); // 목록 처리
    PageResultDTO<ItemDTO, Object[]> getList2(PageRequestDTO requestDTO); // 목록 처리
//
//    MovieDTO getMovie(Long mno);

    default ItemDTO entitiesToDTO(Item item, List<ItemImg> itemImgs) {
        ItemDTO itemDTO = ItemDTO.builder()
                .id(item.getId())
                .itemDetail(item.getItemDetail())
                .regDate(item.getRegDate())
                .modDate(item.getModDate())
                .build();

        List<ItemImgDTO> itemImgDTOList = itemImgs.stream().map(itemImg -> {
            return ItemImgDTO.builder()
                    .imgName(itemImg.getImgName())
                    .path(itemImg.getPath())
                    .uuid(itemImg.getUuid())
                    .build();
        }).collect(Collectors.toList());

        itemDTO.setImageDTOList(itemImgDTOList);
        itemDTO.setItemDetail(itemDTO.getItemDetail());
        itemDTO.setStock(itemDTO.getStock());
        itemDTO.setPrice(itemDTO.getPrice());

        return itemDTO;

    }

    default Map<String, Object> dtoToEntity(ItemDTO itemDTO) {

        Map<String, Object> entityMap = new HashMap<>();

        Item item = Item.builder()
                .id(itemDTO.getId())
                .itemDetail(itemDTO.getItemDetail())
                .stock(itemDTO.getStock())
                .price(itemDTO.getPrice())
                .build();

        entityMap.put("item", item);

        List<ItemImgDTO> imageDTOList = itemDTO.getImageDTOList();

        if (imageDTOList != null && imageDTOList.size() > 0) { // MovieImageDTO 처리

            List<ItemImg> itemImgList = imageDTOList.stream().map(itemImgDTO -> {

                ItemImg itemImg = ItemImg.builder()
                        .imgName(itemImgDTO.getImgName())
                        .path(itemImgDTO.getPath())
                        .uuid(itemImgDTO.getUuid())
                        .item(item)
                        .build();
                return itemImg;
            }).collect(Collectors.toList());

            entityMap.put("imgList", itemImgList);
        }

        return entityMap;
    }
}

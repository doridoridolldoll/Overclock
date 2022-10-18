package overclock.overclock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.dto.*;
import overclock.overclock.entity.Item;
import overclock.overclock.entity.ItemImg;
import overclock.overclock.entity.Posts;
import overclock.overclock.model.BoardType;
import overclock.overclock.repository.ItemImgRepository;
import overclock.overclock.repository.ItemRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemRepository itemRepository; //final

    @Transactional
    @Override
    public Long itemPosting(ItemDTO itemDTO) {
        log.info("dto : {}", itemDTO);
        Item item = dtoToEntity(itemDTO);
        log.info(item);
        itemRepository.save(item);
        return item.getId();
    }

    @Override
    public List<ItemDTO> partsItemList(ItemDTO itemDTO) {
        List<Item> result = itemRepository.findAll();
        log.info("result : {}", result);
        return result.stream().map(new Function<Item, ItemDTO>() {
            @Override
            public ItemDTO apply(Item item) {
                return entityToDTO(item);
            }
        }).collect(Collectors.toList());
    }
}

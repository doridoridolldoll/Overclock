package overclock.overclock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.dto.ItemDTO;
import overclock.overclock.dto.PageRequestDTO;
import overclock.overclock.dto.PageResultDTO;
import overclock.overclock.dto.PostsDTO;
import overclock.overclock.entity.Item;
import overclock.overclock.entity.ItemImg;
import overclock.overclock.entity.Posts;
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
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository; //final

    private final ItemImgRepository itemImgRepository; //final

    @Transactional
    @Override
    public Long register(ItemDTO itemDTO) {

        Map<String, Object> entityMap = dtoToEntity(itemDTO);

        Item item = (Item) entityMap.get("item"); // 자부자

        List<ItemImg> itemImgList = (List<ItemImg>) entityMap.get("imgList");

        itemRepository.save(item);
        itemImgList.forEach(new Consumer<ItemImg>() {
            public void accept(ItemImg itemImg) {
                itemImgRepository.save(itemImg);
            }

            ;
        });

        return item.getId();
    }

    public List<Item> findItem() {
        return itemRepository.findAll();
    }
    @Override
    public PageResultDTO<ItemDTO, Object[]> getList2(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());
        Page<Object[]> result = itemRepository.getListPage(pageable);

        Function<Object[], ItemDTO> fn = (arr -> entitiesToDTO(
                (Item) arr[0],
                (List<ItemImg>) (Arrays.asList((ItemImg) arr[1]))
        ));
        return new PageResultDTO<>(result, fn);
    }


}

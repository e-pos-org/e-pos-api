package e_pos_system.e_pos_system.service.impl;

import e_pos_system.e_pos_system.dto.request.RequestItemDto;
import e_pos_system.e_pos_system.dto.response.ResponseItemDto;
import e_pos_system.e_pos_system.dto.response.paginate.ItemPaginateDto;
import e_pos_system.e_pos_system.entity.Item;
import e_pos_system.e_pos_system.repo.ItemRepo;
import e_pos_system.e_pos_system.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepo itemRepo;
    @Override
    public void create(RequestItemDto dto) {
        Item item = Item.builder()
                .itemId(UUID.randomUUID().toString())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .date(dto.getDate())
                .unitPrice(dto.getUnitPrice())
                .qty(dto.getQty())
                .product(dto.getProductId())
                .build();
        itemRepo.save(item);
    }

    @Override
    public void update(RequestItemDto dto, String id) {
        Optional<Item> selectedItem = itemRepo.findById(id);
        if (selectedItem.isEmpty()){
            throw  new RuntimeException("Item Not Found");
        }
        Item item = selectedItem.get();
        item.setQty(dto.getQty());
        item.setDate(dto.getDate());
        item.setDescription(dto.getDescription());
        item.setTitle(dto.getTitle());
        item.setUnitPrice(dto.getUnitPrice());
        item.setProduct(dto.getProductId());
        itemRepo.save(item);
    }

    @Override
    public void delete(String id) {
        itemRepo.deleteById(id);
    }

    @Override
    public ResponseItemDto getById(String id) {
        Optional<Item> selectedItem = itemRepo.findById(id);
        if (selectedItem.isEmpty()){
            throw new RuntimeException("Item Not Found");
        }
        return toResponseItemDto(selectedItem.get());
    }

    @Override
    public ItemPaginateDto getAll(String searchText, int page, int size) {
        return ItemPaginateDto.builder()
                .itemList(itemRepo.findAllWithSearchText(searchText, PageRequest.of(page,size)).stream().map(this::toResponseItemDto).toList())
                .count(
                        itemRepo.countAllWithSearchText(searchText)
                )
                .build();
    }
    private ResponseItemDto toResponseItemDto(Item item){
        return ResponseItemDto.builder()
                .itemId(item.getItemId())
                .date(item.getDate())
                .description(item.getDescription())
                .qty(item.getQty())
                .unitPrice(item.getUnitPrice())
                .title(item.getTitle())
                .product(item.getProduct())
                .build();
    }
}

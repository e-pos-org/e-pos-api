package e_pos_system.e_pos_system.service;

import e_pos_system.e_pos_system.dto.request.RequestItemDto;
import e_pos_system.e_pos_system.dto.response.ResponseItemDto;
import e_pos_system.e_pos_system.dto.response.paginate.ItemPaginateDto;

public interface ItemService {
    public void create(RequestItemDto dto);
    public void update(RequestItemDto dto, String id);
    public void delete(String id);
    public ResponseItemDto getById(String id);
    public ItemPaginateDto getAll(String searchText, int page, int size);
}

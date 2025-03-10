package e_pos_system.e_pos_system.service;

import e_pos_system.e_pos_system.dto.request.RequestOrderDto;
import e_pos_system.e_pos_system.dto.response.ResponseOrderDto;
import e_pos_system.e_pos_system.dto.response.paginate.OrderPaginateDto;

public interface OrderService {
    public void create(RequestOrderDto dto);
    public void update(RequestOrderDto dto,String id);
    public void delete(String id);

    public ResponseOrderDto getById(String id);
    public OrderPaginateDto getAll(String searchText, int page , int size);

}

package e_pos_system.e_pos_system.service;

import e_pos_system.e_pos_system.dto.request.RequestCustomerDto;
import e_pos_system.e_pos_system.dto.request.RequestProductDto;
import e_pos_system.e_pos_system.dto.response.ResponseProductDto;
import e_pos_system.e_pos_system.dto.response.paginate.ProductPaginateDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public void create(RequestProductDto dto);
    public void update(RequestProductDto dto,String id);
    public void delete(String id);
    public ResponseProductDto getById(String id);
    public ProductPaginateDto getAll(String searchText, int page , int size);
}

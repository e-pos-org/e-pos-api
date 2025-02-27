package e_pos_system.e_pos_system.service;

import e_pos_system.e_pos_system.dto.request.RequestCustomerDto;
import e_pos_system.e_pos_system.dto.response.ResponseCustomerDto;
import e_pos_system.e_pos_system.dto.response.paginate.CustomerPaginateDto;
import org.springframework.stereotype.Service;

@Service

public interface CustomerService {
    public void create(RequestCustomerDto dto);
    public void update(RequestCustomerDto dto, String id);
    public void delete(String id);
    public ResponseCustomerDto getById(String id);
    public CustomerPaginateDto findAll(String searchText, int page, int size);
}

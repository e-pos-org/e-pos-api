package e_pos_system.e_pos_system.service.impl;

import e_pos_system.e_pos_system.dto.request.RequestCustomerDto;
import e_pos_system.e_pos_system.dto.response.ResponseCustomerDto;
import e_pos_system.e_pos_system.dto.response.paginate.CustomerPaginateDto;
import e_pos_system.e_pos_system.entity.Customer;
import e_pos_system.e_pos_system.repo.CustomerRepo;
import e_pos_system.e_pos_system.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    @Override
    public void create(RequestCustomerDto dto) {
        Customer customer = Customer.builder()
                .customerId(UUID.randomUUID().toString())
                .name(dto.getName())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .build();
        customerRepo.save(customer);
    }

    @Override
    public void update(RequestCustomerDto dto, String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ResponseCustomerDto getById(String id) {
        return null;
    }

    @Override
    public CustomerPaginateDto findAll(String searchText, int page, int size) {
        return null;
    }
}

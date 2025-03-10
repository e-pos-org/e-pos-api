package e_pos_system.e_pos_system.service.impl;

import e_pos_system.e_pos_system.dto.request.RequestOrderDto;
import e_pos_system.e_pos_system.dto.response.ResponseOrderDto;
import e_pos_system.e_pos_system.dto.response.paginate.OrderPaginateDto;
import e_pos_system.e_pos_system.entity.Order;
import e_pos_system.e_pos_system.repo.OrderRepo;
import e_pos_system.e_pos_system.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    @Override
    public void create(RequestOrderDto dto) {
        Order order = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .date(dto.getDate())
                .build();
        orderRepo.save(order);
    }

    @Override
    public void update(RequestOrderDto dto, String id) {


    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ResponseOrderDto getById(String id) {
        return null;
    }

    @Override
    public OrderPaginateDto getAll(String searchText, int page, int size) {
        return null;
    }
}

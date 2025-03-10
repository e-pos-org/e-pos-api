package e_pos_system.e_pos_system.api;

import e_pos_system.e_pos_system.dto.request.RequestOrderDto;
import e_pos_system.e_pos_system.repo.OrderRepo;
import e_pos_system.e_pos_system.service.OrderService;
import e_pos_system.e_pos_system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestOrderDto dto){
        orderService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Order was Created!",null),
                HttpStatus.CREATED
        );
    }
}

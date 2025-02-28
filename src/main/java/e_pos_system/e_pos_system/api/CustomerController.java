package e_pos_system.e_pos_system.api;

import e_pos_system.e_pos_system.dto.request.RequestCustomerDto;
import e_pos_system.e_pos_system.service.CustomerService;
import e_pos_system.e_pos_system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto){
        customerService.create(dto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Customer Created!",null),
                HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@RequestBody RequestCustomerDto dto, @PathVariable String id){
        customerService.update(dto,id);

        return new ResponseEntity<>(
                new StandardResponse(201,"Customer Update!",null),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id){
        customerService.delete(id);

        return new ResponseEntity<>(
                new StandardResponse(204,"Customer Delete!",null),
                HttpStatus.NO_CONTENT
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer data!",customerService.getById(id)),
                HttpStatus.OK
        );
    }
    @GetMapping
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam(defaultValue = "",required = false) String searchText,
            @RequestParam(defaultValue = "0",required = false)  int page,
            @RequestParam(defaultValue = "10",required = false)  int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer list!",customerService.findAll(searchText,page,size)),
                HttpStatus.OK
        );
    }
}

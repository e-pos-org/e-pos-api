package e_pos_system.e_pos_system.api;

import e_pos_system.e_pos_system.dto.request.RequestProductDto;
import e_pos_system.e_pos_system.service.ProductService;
import e_pos_system.e_pos_system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class productController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestProductDto dto){
        productService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Product Created!",null),
                HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@RequestBody RequestProductDto dto,@PathVariable String id){
        productService.update(dto,id);
        return new ResponseEntity<>(
                new StandardResponse(201,"Product Updated!",null),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id){
        productService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Product Deleted!",null),
                HttpStatus.NO_CONTENT
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Product data!",productService.getById(id)),
                HttpStatus.OK
        );
    }
    @GetMapping
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam(defaultValue = "",required = false) String searchText,
            @RequestParam(defaultValue = "0",required = false)int page,
            @RequestParam(defaultValue = "10",required = false)int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(201,"Product Created!",productService.getAll(searchText,page,size)),
                HttpStatus.CREATED
        );
    }
}

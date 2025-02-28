package e_pos_system.e_pos_system.api;

import e_pos_system.e_pos_system.dto.request.RequestItemDto;
import e_pos_system.e_pos_system.service.ItemService;
import e_pos_system.e_pos_system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class ItemController {
    private final ItemService itemService;
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestItemDto dto){
        itemService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Created Item",null),
                HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@RequestBody RequestItemDto dto, @PathVariable String id){
        itemService.update(dto,id);
        return new ResponseEntity<>(
                new StandardResponse(201,"Updated Item",null),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id){
        itemService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Delete Item",null),
                HttpStatus.NO_CONTENT
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Item data",itemService.getById(id)),
                HttpStatus.OK
        );
    }
    @GetMapping
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam(defaultValue = "",required = false) String searchText,
            @RequestParam(defaultValue = "0",required = false) int page,
            @RequestParam(defaultValue = "10",required = false) int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(200,"Items list",itemService.getAll(searchText,page,size)),
                HttpStatus.OK
        );
    }
}

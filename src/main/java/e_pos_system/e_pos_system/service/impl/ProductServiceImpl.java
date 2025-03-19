package e_pos_system.e_pos_system.service.impl;
import e_pos_system.e_pos_system.dto.request.RequestProductDto;
import e_pos_system.e_pos_system.dto.response.ResponseProductDto;
import e_pos_system.e_pos_system.dto.response.paginate.ProductPaginateDto;
import e_pos_system.e_pos_system.entity.Product;
import e_pos_system.e_pos_system.exception.EntryNotFoundException;
import e_pos_system.e_pos_system.repo.ProductRepo;
import e_pos_system.e_pos_system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public void create(RequestProductDto dto) {
       try {
           Product product = Product.builder()
                   .productId(UUID.randomUUID().toString())
                   .title(dto.getTitle())
                   .description(dto.getDescription())
                   .date(dto.getDate())
                   .unitPrice(dto.getUnitPrice())
                   .qty(dto.getQty())
                   .build();
           productRepo.save(product);

       }catch (Exception e){
           throw new RuntimeException(e);
       }
    }

    @Override
    public void update(RequestProductDto dto, String id) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()){
            throw new EntryNotFoundException("Product Not Found");
        }
        Product product = selectedProduct.get();
        product.setDate(dto.getDate());
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setUnitPrice(dto.getUnitPrice());
        product.setQty(dto.getQty());
        productRepo.save(product);
    }

    @Override
    public void delete(String id) {
        productRepo.deleteById(id);
    }

    @Override
    public ResponseProductDto getById(String id) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()){
            throw new EntryNotFoundException("Product Not Found");
        }
        return toResponseProductDto(selectedProduct.get());
    }

    @Override
    public ProductPaginateDto getAll(String searchText, int page, int size) {
        return ProductPaginateDto.builder()
                .dataList(productRepo.findAllWithSearchText(searchText, PageRequest.of(page,size)).stream().map(this::toResponseProductDto).toList())
                .count(
                        productRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    private ResponseProductDto toResponseProductDto(Product product){
        return ResponseProductDto.builder()
                .productId(product.getProductId())
                .title(product.getTitle())
                .description(product.getDescription())
                .date(product.getDate())
                .unitPrice(product.getUnitPrice())
                .qty(product.getQty())
                .build();
    }
}

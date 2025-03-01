package e_pos_system.e_pos_system.dto.response;

import e_pos_system.e_pos_system.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseItemDto {
    private String itemId;
    private String title;
    private String description;
    private Date date;
    private double unitPrice;
    private int qty;
    private Product product;
}
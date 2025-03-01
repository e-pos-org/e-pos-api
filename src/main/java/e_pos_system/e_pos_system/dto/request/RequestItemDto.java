package e_pos_system.e_pos_system.dto.request;

import e_pos_system.e_pos_system.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestItemDto {
    private String title;
    private String description;
    private Date date;
    private double unitPrice;
    private int qty;
    private Product productId;
}

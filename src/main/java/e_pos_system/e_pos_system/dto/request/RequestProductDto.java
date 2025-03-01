package e_pos_system.e_pos_system.dto.request;

import e_pos_system.e_pos_system.entity.Product;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RequestProductDto {
    private String title;
    private String description;
    private Date date;
    private double unitPrice;
    private int qty;
}

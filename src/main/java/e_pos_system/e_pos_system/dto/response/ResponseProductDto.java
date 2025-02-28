package e_pos_system.e_pos_system.dto.response;

import e_pos_system.e_pos_system.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseProductDto {
    private String productId;
    private String title;
    private String description;
    private String date;
    private Customer customer;
}

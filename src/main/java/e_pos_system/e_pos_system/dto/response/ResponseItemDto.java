package e_pos_system.e_pos_system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseItemDto {
    private String itemId;
    private String title;
    private String description;
    private String date;
    private double unitPrice;
    private int qty;
}
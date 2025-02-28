package e_pos_system.e_pos_system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestItemDto {
    private String title;
    private String description;
    private String date;
    private double unitPrice;
    private int qty;
}

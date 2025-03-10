package e_pos_system.e_pos_system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseOrderDto {
    private String orderId;
    private String title;
    private String description;
    private Date date;
}

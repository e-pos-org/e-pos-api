package e_pos_system.e_pos_system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RequestOrderDto {
    private String title;
    private String description;
    private Date date;
}

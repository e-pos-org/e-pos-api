package e_pos_system.e_pos_system.dto.response.paginate;

import e_pos_system.e_pos_system.dto.response.ResponseOrderDto;
import e_pos_system.e_pos_system.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderPaginateDto {
    private long count;
    private List<ResponseOrderDto> orderList;
}

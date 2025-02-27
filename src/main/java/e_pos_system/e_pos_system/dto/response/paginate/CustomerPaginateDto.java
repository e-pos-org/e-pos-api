package e_pos_system.e_pos_system.dto.response.paginate;

import e_pos_system.e_pos_system.dto.response.ResponseCustomerDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CustomerPaginateDto {
    private long count;
    private List<ResponseCustomerDto> dataList;
}

package e_pos_system.e_pos_system.dto.response.paginate;

import e_pos_system.e_pos_system.dto.response.ResponseItemDto;
import e_pos_system.e_pos_system.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ItemPaginateDto {
    private long count;
    private List<ResponseItemDto> itemList;
}

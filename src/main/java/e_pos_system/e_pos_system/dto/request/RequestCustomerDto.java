package e_pos_system.e_pos_system.dto.request;

import lombok.*;
import org.springframework.stereotype.Repository;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RequestCustomerDto {
    private String name;
    private String email;
    private String address;
    private String phone;
}

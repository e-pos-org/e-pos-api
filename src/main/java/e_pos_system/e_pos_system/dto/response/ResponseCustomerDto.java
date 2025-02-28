package e_pos_system.e_pos_system.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseCustomerDto {
   private String customerId;
   private String name;
   private String email;
   private String address;
   private String phone;
}

package e_pos_system.e_pos_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "cus_order")
public class Order {
    @Id
    @Column(name = "orderId",nullable = false,length = 80)
    private String orderId;
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSD", timezone = "Asia/Colombo")
    private Date date;
}

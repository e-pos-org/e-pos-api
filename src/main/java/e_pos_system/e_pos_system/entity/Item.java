package e_pos_system.e_pos_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name="item")
public class Item {
    @Id
    @Column(name = "itemId", nullable = false, length = 80)
    private String itemId;
    @Column(name = "title", nullable = false, length = 255 )
    private String title;
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Column(name = "date", nullable = false, length = 80)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSD", timezone = "Asia/Colombo")
    private Date date;
    @Column(name = "unitPrice",nullable = false, length = 20)
    private double unitPrice;
    @Column(name = "qty",nullable = false, length = 20)
    private int qty;
    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private Product product;
}

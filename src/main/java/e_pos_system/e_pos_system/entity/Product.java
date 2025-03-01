package e_pos_system.e_pos_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "product")
public class Product {
    @Id
    @Column(name = "productId", nullable = false, length = 80)
    private String productId;
    @Column(name = "title", nullable = false, length = 255)
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
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Item> itemList;
}

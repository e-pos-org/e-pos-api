package e_pos_system.e_pos_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "data", nullable = false, length = 80)
    private String data;
    @Column(name = "unitPrice",nullable = false, length = 20)
    private double unitPrice;
    @Column(name = "qty",nullable = false, length = 20)
    private int qty;
}

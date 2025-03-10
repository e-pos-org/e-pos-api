package e_pos_system.e_pos_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "customer")
public class Customer {
    @Id
    @Column(name = "customerId",nullable = false,length = 80)
    private String customerId;
    @Column(name = "name",nullable = false,length = 255)
    private String name;
    @Column(name = "email",nullable = false,length = 255,unique = true)
    private String email;
    @Column(name = "address",nullable = false,length = 255)
    private String address;
    @Column(name = "phone",nullable = false,length = 20)
    private String phone;
}

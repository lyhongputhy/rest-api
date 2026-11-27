package kh.edu.istad.restfulapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "m1_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = false, nullable = false, length = 30)
    private String code;
    @Column (unique = true, nullable = false)
    private String name;
    @Column (nullable = false)
    private Boolean isAvailable;
    @Column ( nullable = false)
    private BigDecimal price;
    @Column ( nullable = false)
    private Integer qty;

    @ManyToOne
    private Category category;
}

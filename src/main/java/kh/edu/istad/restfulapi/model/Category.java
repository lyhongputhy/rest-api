package kh.edu.istad.restfulapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "m1_categories")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (unique = true, nullable = false, length = 30)
    private String name;
    private String icon;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}

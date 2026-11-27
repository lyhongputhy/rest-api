package kh.edu.istad.restfulapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "m1_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column (unique = true, nullable = false, length = 50)
    private String username;
    @Column ( nullable = false, length = 255)
    // default length = 255
    private String password;
    @Column ( nullable = false, length = 50)
    private String fullName;
    @Column (nullable = false)
    private Boolean isActive;

    @OneToOne(mappedBy = "user")
    private Customer customer;
}

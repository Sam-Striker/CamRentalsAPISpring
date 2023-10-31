package com.striker.CamRentalsSpring.modal;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    @Column(unique = true)
    private String role_name;
    @OneToMany(mappedBy = "role")
    @JsonManagedReference
    private List<Users> users;

    public Roles(int role_id) {
        this.role_id = role_id;
    }

}

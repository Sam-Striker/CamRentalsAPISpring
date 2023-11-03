package com.striker.CamRentalsSpring.modal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@ToString
@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    @NotBlank(message = "NationalID cannot be blank")
    @Pattern(regexp = "\\d+", message = "NationalID must contain only numbers")
    private String nationalID;
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotBlank(message = "Address cannot be blank")
    private String address;
    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "\\d+", message = "Phone number must contain only numbers")
    private String phone_nbr;
    private LocalDate date;
    private String role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Camera> cameras;

    public Users(int id) {
        this.id = id;
    }

    public Users() {
    }




}

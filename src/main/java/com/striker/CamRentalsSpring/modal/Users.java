package com.striker.CamRentalsSpring.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String nationalID;
    private String username;
    private String password;
    private String address;
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

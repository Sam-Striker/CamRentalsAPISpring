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
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private Roles role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Camera> cameras;

    public Users(int id) {
        this.id = id;
    }

    public Users() {
    }

    public Users(int id, String nationalID, String username, String password, String address, String phone_nbr, LocalDate date, Roles role, List<Camera> cameras) {
        this.id = id;
        this.nationalID = nationalID;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone_nbr = phone_nbr;
        this.date = date;
        this.role = role;
        this.cameras = cameras;
    }



}

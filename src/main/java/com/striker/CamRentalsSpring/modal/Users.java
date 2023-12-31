package com.striker.CamRentalsSpring.modal;
;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
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
    @Pattern(regexp = "\\d+", message = "NationalID must contain only numbers")
    private String nationalID;
    private String username;
    private String password;
    private String address;

    @Pattern(regexp = "\\d+", message = "Phone number must contain only numbers")
    private String phone_nbr;
    private LocalDate date;
    private String role;






}

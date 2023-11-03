package com.striker.CamRentalsSpring.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@Data
@ToString
@Getter
@Setter
public class UserDTO {
    private int id;
    private String nationalID;
    private String username;
    private String password;
    private String address;
    private String phone_nbr;
    private LocalDate date;
    private String role;
}

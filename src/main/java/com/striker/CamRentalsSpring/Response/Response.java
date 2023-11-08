package com.striker.CamRentalsSpring.Response;

import com.striker.CamRentalsSpring.modal.Users;
import lombok.*;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Response {
    String message;
    Boolean status;
    String role;
    Optional<Users> userCRed;
}

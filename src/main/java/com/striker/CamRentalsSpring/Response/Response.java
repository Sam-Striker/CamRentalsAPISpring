package com.striker.CamRentalsSpring.Response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Response {
    String message;
    Boolean status;
    String role;
}

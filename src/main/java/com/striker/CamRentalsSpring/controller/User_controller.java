package com.striker.CamRentalsSpring.controller;

import com.striker.CamRentalsSpring.DTO.LoginDTO;
import com.striker.CamRentalsSpring.DTO.UserDTO;
import com.striker.CamRentalsSpring.Response.Response;
import com.striker.CamRentalsSpring.modal.Users;
import com.striker.CamRentalsSpring.service.UserImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/24239/user")
public class User_controller {

    @Autowired
    private UserImply user_service;

    public User_controller(UserImply user_service) {
        this.user_service = user_service;
    }

    @PostMapping("/save")
    public ResponseEntity<?>  createAccount(@RequestBody UserDTO serDTO) {
        Response loginResponse = user_service. createAccount(serDTO);
        return ResponseEntity.ok(loginResponse);
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        Response loginResponse = user_service.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping(path = "/listall")
    public List<Users> retrieveCam() {
        return user_service.accountList();
    }


}

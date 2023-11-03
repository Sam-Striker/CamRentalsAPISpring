package com.striker.CamRentalsSpring.service;

import com.striker.CamRentalsSpring.DTO.LoginDTO;
import com.striker.CamRentalsSpring.DTO.UserDTO;
import com.striker.CamRentalsSpring.Response.Response;
import com.striker.CamRentalsSpring.modal.Users;

import java.util.List;

public interface UserInterf {

    Response createAccount(UserDTO userDTO);
    Response loginUser(LoginDTO loginDTO);
    public List<Users> accountList();

//    public Roles findRoleByName(String roleName);
//    public Users getUserByNationalID(String nationalID);

}

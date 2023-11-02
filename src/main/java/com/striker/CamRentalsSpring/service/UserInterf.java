package com.striker.CamRentalsSpring.service;

import com.striker.CamRentalsSpring.DTO.LoginDTO;
import com.striker.CamRentalsSpring.Response.LoginResponse;
import com.striker.CamRentalsSpring.modal.Users;

import java.util.List;

public interface UserInterf {
    Users createAccount(Users account);
    LoginResponse loginUser(LoginDTO loginDTO);
    public List<Users> accountList();

//    public Roles findRoleByName(String roleName);
//    public Users getUserByNationalID(String nationalID);

}

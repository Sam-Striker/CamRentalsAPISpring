package com.striker.CamRentalsSpring.service;
import com.striker.CamRentalsSpring.DTO.LoginDTO;
import com.striker.CamRentalsSpring.DTO.UserDTO;
import com.striker.CamRentalsSpring.Response.Response;
import com.striker.CamRentalsSpring.modal.Users;
import com.striker.CamRentalsSpring.repository.User_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UserImply implements UserInterf{

    private final User_repository user_repo;

    @Autowired
    public UserImply(User_repository user_repo) {
        this.user_repo = user_repo;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Response createAccount(UserDTO userDTO) {
        if (userDTO.getNationalID() == null || userDTO.getUsername() == null ||
                userDTO.getPassword() == null || userDTO.getAddress() == null ||
                userDTO.getPhone_nbr() == null) {
            return new Response("All fields must be provided", false, "", null);
        }
        if (user_repo.existsByNationalID(userDTO.getNationalID())) {
            return new Response("National ID already exists", false, "", null);
        }

        if (!userDTO.getNationalID().matches("\\d+")) {
            return new Response("National ID must contain only numbers", false, "", null);
        }

        if (!userDTO.getPhone_nbr().matches("\\d+")) {
            return new Response("Phone number must contain only numbers", false, "", null);
        }

        Users user = new Users();
        user.setNationalID(userDTO.getNationalID());
        user.setUsername(userDTO.getUsername());

        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(hashedPassword);

        user.setAddress(userDTO.getAddress());
        user.setPhone_nbr(userDTO.getPhone_nbr());
        user.setDate(userDTO.getDate());
        user.setRole(userDTO.getRole());

        Users savedUser = user_repo.save(user);
        String role = savedUser.getRole();

        return new Response("User created successfully" , true, role, null);

    }

    @Override
    public Response loginUser(LoginDTO loginDTO) {
        Users user1 = user_repo.findByNationalID(loginDTO.getNationalID());
        if(user1 != null){
            String password = loginDTO.getPassword();
            String encodePassword = user1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
            if (isPwdRight){
                Optional<Users> user = user_repo.findByNationalIDAndPassword(loginDTO.getNationalID(), encodePassword);
                if(user.isPresent()) {
                    String role = user1.getRole();
                    return new Response("login successfully as " , true, role, user);
                }else {
                    return new Response("login failed", false, "", null);
                }
            } else {
                return new Response("password not match", false, "", null);
            }
        } else {
            return new Response("National Id Doesn't exist", false, "", null);
        }
    }

    @Override
    public List<Users> accountList() {
        return user_repo.findAll();
    }

//    @Override
//    public Roles findRoleByName(String roleName) {
//        return user_repo.findRoleByName(roleName);
//    }
//
//    @Override
//    public Users getUserByNationalID(String nationalID) {
//        return user_repo.getUserByNationalID(nationalID);
//    }
}

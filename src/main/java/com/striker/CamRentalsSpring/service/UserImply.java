package com.striker.CamRentalsSpring.service;
import com.striker.CamRentalsSpring.DTO.LoginDTO;
import com.striker.CamRentalsSpring.Response.LoginResponse;
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
    public Users createAccount(Users account) {
        String hashedPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(hashedPassword);
        return user_repo.save(account);
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        Users user1 = user_repo.findByNationalID(loginDTO.getNationalID());
        if(user1 != null){
            String password = loginDTO.getPassword();
            String encodePassword = user1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
            if (isPwdRight){
                Optional<Users> user = user_repo.findByNationalIDAndPassword(loginDTO.getNationalID(), encodePassword);
                if(user.isPresent()) {
                    return new LoginResponse("login successfully", "true");
                }else {
                    return new LoginResponse("login failed", "false");
                }
            } else {
                return new LoginResponse("password not match", "false");
            }
        } else {
            return new LoginResponse("National Id Doesn't exist", "false");
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

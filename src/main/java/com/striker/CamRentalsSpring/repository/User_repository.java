package com.striker.CamRentalsSpring.repository;

import com.striker.CamRentalsSpring.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User_repository extends JpaRepository<Users, Integer> {

    Optional<Users> findByNationalIDAndPassword(String nationalID, String Password);
    Users findByNationalID(String nationalID);
    boolean existsByNationalID(String nationalID);

//    Roles findRoleByName(String roleName);
//    Users getUserByNationalID(String nationalID);


}

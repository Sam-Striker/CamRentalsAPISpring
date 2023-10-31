package com.striker.CamRentalsSpring.repository;

import com.striker.CamRentalsSpring.modal.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Role_repository extends JpaRepository<Roles, Integer> {
}

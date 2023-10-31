package com.striker.CamRentalsSpring.service;
import com.striker.CamRentalsSpring.modal.Roles;
import com.striker.CamRentalsSpring.repository.Role_repository;
import com.striker.CamRentalsSpring.repository.User_repository;
import org.springframework.stereotype.Service;

@Service
public class rolesImply  implements  roleInterf{
    private final Role_repository role_repo;

    public rolesImply(Role_repository role_repo) {
        this.role_repo = role_repo;
    }

    @Override
    public Roles createRoles(Roles role) {
        return role_repo.save(role);
    }
}

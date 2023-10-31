package com.striker.CamRentalsSpring.controller;
;
import com.striker.CamRentalsSpring.modal.Roles;
import com.striker.CamRentalsSpring.service.rolesImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/24239/role")
public class Roles_controller {

    @Autowired
    private rolesImply roles_service;

    public Roles_controller(rolesImply roles_service) {
        this.roles_service = roles_service;
    }

    @PostMapping("/save")
    public Roles saveRoles (@RequestBody Roles roles)
    {
        return roles_service.createRoles(roles);
    }

}

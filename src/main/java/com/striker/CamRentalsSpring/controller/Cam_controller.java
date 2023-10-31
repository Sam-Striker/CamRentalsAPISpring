package com.striker.CamRentalsSpring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.striker.CamRentalsSpring.modal.Camera;
import com.striker.CamRentalsSpring.service.CameraImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/24239/cam")
public class Cam_controller {

    @Autowired
    private CameraImply cam_service;

    public Cam_controller(CameraImply cam_service) {
        this.cam_service = cam_service;
    }

    @PostMapping("/save")
    public Camera save_Cam(@RequestBody Camera st) {
        return cam_service.save_Cam(st);
    }

    @GetMapping(path = "/listall")
    public List<Camera> retrieveCam() {
        return cam_service.retrieveCam();
    }

    @GetMapping(path = "/find/{serialNbr}")
    public Camera findCam(@PathVariable String serialNbr) {
        return cam_service.findCam(serialNbr);
    }

    @PutMapping("/updateCamStatus")
    public String updateCameraStatus(@RequestBody Camera updatedCamera) {
        int id = updatedCamera.getId();
        int newStatus = updatedCamera.getStatus();
        cam_service.updateCameraStatus(id, newStatus);
        return "deleted succesfully";
    }

    @PutMapping("/updateCamRentStatus")
    public String updateCameraRentStatus(@RequestBody Camera updatedCamera) {
        int id = updatedCamera.getId();
        String newRentStatus = updatedCamera.getRentStatus();
        cam_service.updateCameraRentStatus(id, newRentStatus);
        return "rented succesfully";
    }

}

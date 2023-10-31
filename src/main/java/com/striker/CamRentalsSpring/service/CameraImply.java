package com.striker.CamRentalsSpring.service;

import com.striker.CamRentalsSpring.modal.Camera;
import com.striker.CamRentalsSpring.repository.Cam_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CameraImply implements cameraInterf{

    private final Cam_repository cam_repo;
    @Autowired
    public CameraImply(Cam_repository cam_repo) {
        this.cam_repo = cam_repo;
    }

    @Override
    public Camera save_Cam(Camera st) {
        return cam_repo.save(st);
    }

    @Override
    public List<Camera> retrieveCam() {
        return cam_repo.findAll();
    }

    @Override
    public Camera findCam(String serialNbr) {
        return cam_repo.findByserialNbr(serialNbr);
    }

    @Override
    public void updateCameraStatus(int id, int newStatus) {
         cam_repo.updateCameraStatus(id, newStatus);
    }

    @Override
    public void updateCameraRentStatus(int id, String newRentStatus) {
          cam_repo.updateRentStatus(id, newRentStatus);
    }
}

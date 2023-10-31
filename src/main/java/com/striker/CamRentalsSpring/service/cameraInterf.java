package com.striker.CamRentalsSpring.service;

import com.striker.CamRentalsSpring.modal.Camera;

import java.util.List;

public interface cameraInterf {
    public Camera save_Cam(Camera st);
    public List<Camera> retrieveCam();
    public Camera findCam(String serialNbr);
    public void updateCameraStatus(int id, int newStatus);
    public void updateCameraRentStatus(int id,  String newRentStatus);

}

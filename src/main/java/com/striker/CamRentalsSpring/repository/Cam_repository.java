package com.striker.CamRentalsSpring.repository;

import com.striker.CamRentalsSpring.modal.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface Cam_repository extends JpaRepository<Camera, Integer> {
    Camera findByserialNbr(String serialNbr);
    @Modifying
    @Query("UPDATE Camera c SET c.status = :newStatus WHERE c.id = :id")
    @Transactional
    void updateCameraStatus(@Param("id") Integer id, @Param("newStatus") int newStatus);

    @Modifying
    @Query("UPDATE Camera c SET c.rentStatus = :newRentStatus WHERE c.id = :id")
    @Transactional
    void updateRentStatus(@Param("id") Integer id, @Param("newRentStatus") String newRentStatus);

}

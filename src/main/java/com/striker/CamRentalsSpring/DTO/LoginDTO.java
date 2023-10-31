package com.striker.CamRentalsSpring.DTO;


public class LoginDTO {
    private String nationalID;
    private String password;

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public LoginDTO() {
    }

    public LoginDTO(String nationalID, String password) {
        this.nationalID = nationalID;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "nationalID='" + nationalID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

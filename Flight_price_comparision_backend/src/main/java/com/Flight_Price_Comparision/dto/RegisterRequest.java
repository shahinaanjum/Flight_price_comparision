package com.Flight_Price_Comparision.dto;
public class RegisterRequest {
    private String userName;
    private String email;
    private String password;
    private String roll;
    public RegisterRequest() {
    }
    public RegisterRequest(String userName, String email, String password, String roll) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roll = roll;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRoll() {
        return roll;
    }
    public void setRoll(String roll) {
        this.roll = roll;
    }
}
package com.example.projectmcs;

public class User {
    String nama;
    String email;
    String password;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User(String nama, String email, String password, String phoneNumber) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    String phoneNumber;
}

package com.example.memorand.perfil;

public class ProfileItem {
    private String name;
    private String email;
    private String status;

    public ProfileItem(String name, String email) {
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }
}
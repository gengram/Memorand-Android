package com.example.memorand.api;

public class User {
    private String user_id;
    private String user_email;
    private String user_pass;
    private String user_type;
    private String user_name;
    private String user_pat;
    private String user_mat;
    private String user_status;
    private String user_profile;

    public User() {}

    public User(String user_email, String user_pass) {
        this.user_email = user_email;
        this.user_pass = user_pass;
    }

    public User(String user_id, String user_name, String user_pat, String user_mat, String user_profile) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pat = user_pat;
        this.user_mat = user_mat;
        this.user_profile = user_profile;
    }

    public User(String user_id, String user_email, String user_pass, String user_type, String user_name, String user_pat, String user_mat, String user_status, String user_profile) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_pass = user_pass;
        this.user_type = user_type;
        this.user_name = user_name;
        this.user_pat = user_pat;
        this.user_mat = user_mat;
        this.user_status = user_status;
        this.user_profile = user_profile;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pat() {
        return user_pat;
    }

    public void setUser_pat(String user_pat) {
        this.user_pat = user_pat;
    }

    public String getUser_mat() {
        return user_mat;
    }

    public void setUser_mat(String user_mat) {
        this.user_mat = user_mat;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(String user_profile) {
        this.user_profile = user_profile;
    }

}


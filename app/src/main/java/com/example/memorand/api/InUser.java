package com.example.memorand.api;

public class InUser {
    private String inst_id;
    private String user_id;

    public InUser() {}

    public InUser(String inst_id, String user_id) {
        this.inst_id = inst_id;
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getInst_id() {
        return inst_id;
    }

    public void setInst_id(String inst_id) {
        this.inst_id = inst_id;
    }

}

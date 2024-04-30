package com.example.memorand.api;

public class CollabUser {
    private String collab_id;
    private String user_id;

    public CollabUser() {}

    public CollabUser(String collab_id, String user_id) {
        this.collab_id = collab_id;
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCollab_id() {
        return collab_id;
    }

    public void setCollab_id(String collab_id) {
        this.collab_id = collab_id;
    }
}

package com.example.memorand.api;

public class Collab {
    private String collab_id;
    private String collab_status;
    private String team_id;
    private String proj_id;

    public Collab() {}

    public Collab(String collab_id, String collab_status, String team_id, String proj_id) {
        this.collab_id = collab_id;
        this.collab_status = collab_status;
        this.team_id = team_id;
        this.proj_id = proj_id;
    }

    public String getProj_id() {
        return proj_id;
    }

    public void setProj_id(String proj_id) {
        this.proj_id = proj_id;
    }

    public String getCollab_id() {
        return collab_id;
    }

    public void setCollab_id(String collab_id) {
        this.collab_id = collab_id;
    }

    public String getCollab_status() {
        return collab_status;
    }

    public void setCollab_status(String collab_status) {
        this.collab_status = collab_status;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

}

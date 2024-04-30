package com.example.memorand.api;

public class InTeam {
    private String inst_id;
    private String team_id;

    public InTeam() {}

    public InTeam(String inst_id, String team_id) {
        this.inst_id = inst_id;
        this.team_id = team_id;
    }

    public String getInst_id() {
        return inst_id;
    }

    public void setInst_id(String inst_id) {
        this.inst_id = inst_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }
}

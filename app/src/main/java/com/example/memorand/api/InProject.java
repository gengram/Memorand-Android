package com.example.memorand.api;

public class InProject {
    private String inst_id;
    private String proj_id;

    public InProject() {}

    public InProject(String inst_id, String proj_id) {
        this.inst_id = inst_id;
        this.proj_id = proj_id;
    }

    public String getProj_id() {
        return proj_id;
    }

    public void setProj_id(String proj_id) {
        this.proj_id = proj_id;
    }

    public String getInst_id() {
        return inst_id;
    }

    public void setInst_id(String inst_id) {
        this.inst_id = inst_id;
    }

}

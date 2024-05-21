package com.example.memorand.api;

import java.sql.Timestamp;

public class Task {
    private String task_id;
    private String task_name;
    private String task_info;
    private Timestamp task_sdate;
    private Timestamp task_edate;
    private String task_status;
    private String task_prior;
    private String task_diff;

    public Task() {}

    public Task(String task_id, String task_name, String task_info, Timestamp task_sdate, Timestamp task_edate, String task_status, String task_prior, String task_diff) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_info = task_info;
        this.task_sdate = task_sdate;
        this.task_edate = task_edate;
        this.task_status = task_status;
        this.task_prior = task_prior;
        this.task_diff = task_diff;
    }

    public String getTask_diff() {
        return task_diff;
    }

    public void setTask_diff(String task_diff) {
        this.task_diff = task_diff;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_info() {
        return task_info;
    }

    public void setTask_info(String task_info) {
        this.task_info = task_info;
    }

    public Timestamp getTask_sdate() {
        return task_sdate;
    }

    public void setTask_sdate(Timestamp task_sdate) {
        this.task_sdate = task_sdate;
    }

    public Timestamp getTask_edate() {
        return task_edate;
    }

    public void setTask_edate(Timestamp task_edate) {
        this.task_edate = task_edate;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public String getTask_prior() {
        return task_prior;
    }

    public void setTask_prior(String task_prior) {
        this.task_prior = task_prior;
    }
}

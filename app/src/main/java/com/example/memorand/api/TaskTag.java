package com.example.memorand.api;

public class TaskTag {
    private String task_id;
    private String tag_id;

    public TaskTag() {
    }

    public TaskTag(String task_id, String tag_id) {
        this.task_id = task_id;
        this.tag_id = tag_id;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }
}

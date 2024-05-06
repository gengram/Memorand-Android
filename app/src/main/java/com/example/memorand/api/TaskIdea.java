package com.example.memorand.api;

public class TaskIdea {
    private String task_id;
    private String idea_id;

    public TaskIdea(String task_id, String idea_id)
    {
        this.task_id = task_id;
        this.idea_id = idea_id;
    }

    public String getIdea_id()
    {
        return idea_id;
    }

    public void setIdea_id(String idea_id)
    {
        this.idea_id = idea_id;
    }

    public String getTask_id()
    {
        return task_id;
    }

    public void setTask_id(String task_id)
    {
        this.task_id = task_id;
    }
}

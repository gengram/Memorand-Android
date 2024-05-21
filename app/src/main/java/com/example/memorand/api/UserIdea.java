package com.example.memorand.api;

public class UserIdea {
    private String user_id;
    private String idea_id;

    public UserIdea(String user_id, String idea_id)
    {
        this.user_id = user_id;
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

    public String getUser_id()
    {
        return user_id;
    }

    public void setUser_id(String user_id)
    {
        this.user_id = user_id;
    }
}

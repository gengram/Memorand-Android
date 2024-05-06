package com.example.memorand.api;

public class UserNote {
    private String user_id;
    private String user_note;

    public UserNote(String user_id, String user_note)
    {
        this.user_id = user_id;
        this.user_note = user_note;
    }

    public String getUser_note()
    {
        return user_note;
    }

    public void setUser_note(String user_note)
    {
        this.user_note = user_note;
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

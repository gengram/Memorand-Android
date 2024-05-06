package com.example.memorand.api;

public class UserCanva {
    private String user_id;
    private String canva_id;

    public UserCanva(String user_id, String canva_id)
    {
        this.user_id = user_id;
        this.canva_id = canva_id;
    }

    public String getCanva_id()
    {
        return canva_id;
    }

    public void setCanva_id(String canva_id)
    {
        this.canva_id = canva_id;
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

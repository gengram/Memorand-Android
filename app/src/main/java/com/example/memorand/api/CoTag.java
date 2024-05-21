package com.example.memorand.api;

public class CoTag {
    private String collab_id;
    private String tag_id;

    public CoTag() {}

    public CoTag(String collab_id, String tag_id) {
        this.collab_id = collab_id;
        this.tag_id = tag_id;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getCollab_id() {
        return collab_id;
    }

    public void setCollab_id(String collab_id) {
        this.collab_id = collab_id;
    }
}

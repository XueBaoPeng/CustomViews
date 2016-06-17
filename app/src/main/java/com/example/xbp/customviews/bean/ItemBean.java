package com.example.xbp.customviews.bean;

/**
 * Created by xbp on 2016/6/17.
 */
public class ItemBean  {
    private String title;
    private String description;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemBean(String title, String description) {
        this.title = title;
        this.description = description;
    }
}

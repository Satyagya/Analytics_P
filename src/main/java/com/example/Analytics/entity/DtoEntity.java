package com.example.Analytics.entity;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class DtoEntity {

    @Id
    private String id;
    private int channelId;
    private String categoryPreference;
    private String postId;
    private String type;
    private String categoryName;
    private String timeStamp;
    private String action;
    private Date dateAndTime;

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }


    public String getCategoryPreference() {
        return categoryPreference;
    }

    public void setCategoryPreference(String categoryPreference) {
        this.categoryPreference = categoryPreference;
    }

    @Override
    public String toString() {
        return "DtoEntity{" +
                "user_id='" + id + '\'' +
                ", channelId='" + channelId + '\'' +
                ", categoryPreference='" + categoryPreference + '\'' +
                ", postId='" + postId + '\'' +
                ", type='" + type + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}

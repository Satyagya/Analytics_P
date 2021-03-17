package com.example.Analytics.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Document(collection = "quizUsers")
public class QuizUsersEntity {


    @Id
    private String id;
    private int channelId;
    private boolean status;
    private String categoryPreference;

    //changes
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date timestamp;
    //changes


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public QuizUsersEntity(int channelId, String id, String categoryPreference, boolean status) {
        this.id = id;
        this.channelId = channelId;
        this.status = status;
        this.categoryPreference = categoryPreference;
    }


    public String getid() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCategoryPreference() {
        return categoryPreference;
    }

    public void setCategoryPreference(String categoryPreference) {
        this.categoryPreference = categoryPreference;
    }


    @Override
    public String toString() {
        return "QuizUsersEntity{" +
                "userId='" + id + '\'' +
                ", channelId=" + channelId +
                ", status='" + status + '\'' +
                ", categoryPreference='" + categoryPreference + '\'' +

                '}';
    }
}


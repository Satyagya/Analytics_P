package com.example.Analytics.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "posts")
public class PostsEntity {

        @Id
        private String postId;
        private Date dateAndTime;
        private String type;
        private int channelId;
        private int likes = 0;
        private int dislikes = 0;
        private int comments;
        private String categoryPreference;
        private int id;

    public PostsEntity(int channelId, String getid, String categoryPreference, boolean b) {
    }

    public String getPostId() {
            return postId;
        }
        public void setPostId(String postId) {
            this.postId = postId;
        }
        public Date getDateAndTime() {
            return dateAndTime;
        }
        public void setDateAndTime(Date dateAndTime) {
            this.dateAndTime = dateAndTime;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public int getChannelId() {
            return channelId;
        }
        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }
        public int getLikes() {
            return likes;
        }
        public void setLikes(int likes) {
            this.likes = likes;
        }
        public int getDislikes() {
            return dislikes;
        }
        public void setDislikes(int dislikes) {
            this.dislikes = dislikes;
        }
        public int getComments() {
            return comments;
        }
        public void setComments(int comments) {
            this.comments = comments;
        }
        public String getCategoryPreference() {
            return categoryPreference;
        }
        public void setCategoryPreference(String categoryPreference) {
            this.categoryPreference = categoryPreference;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        @Override
        public String toString() {
            return "PostsEntity{" +
                    "postId='" + postId + '\'' +
                    ", dateAndTime=" + dateAndTime +
                    ", type='" + type + '\'' +
                    ", channelId=" + channelId +
                    ", likes=" + likes +
                    ", dislikes=" + dislikes +
                    ", comment=" + comments +
                    ", categoryPreference='" + categoryPreference + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

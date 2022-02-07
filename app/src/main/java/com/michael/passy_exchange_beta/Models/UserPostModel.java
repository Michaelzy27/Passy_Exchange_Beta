package com.michael.passy_exchange.Models;

public class UserPostModel {
    String postImage;
    String postName;
    String postTime;
    String postTitle;
    String postDescription;

    public UserPostModel(String postImage, String postName, String postTime, String postTitle, String postDescription) {
        this.postImage = postImage;
        this.postName = postName;
        this.postTime = postTime;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }
}

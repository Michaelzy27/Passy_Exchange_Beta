package com.michael.passy_exchange.Models;

public class NotificationModel {

    String title;
    String description;
    String image;
    String date;
    boolean recent;

    public NotificationModel(String title, String description, String image, String date, boolean recent) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.date = date;
        this.recent = recent;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isRecent() {
        return recent;
    }

    public void setRecent(boolean recent) {
        this.recent = recent;
    }
}

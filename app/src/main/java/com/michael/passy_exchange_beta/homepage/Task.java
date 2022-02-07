package com.michael.passy_exchange.homepage;

public class Task {
    String task_desc;
    String deadline;
    String track;
    String status;
    int arrow;


    public Task(String task_desc, String deadline, String track, String status, int arrow) {
        this.task_desc = task_desc;
        this.deadline = deadline;
        this.track = track;
        this.status = status;
        this.arrow = arrow;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getTrack() {
        return track;
    }

    public String getStatus() {
        return status;
    }

    public int getArrow() {
        return arrow;
    }

}

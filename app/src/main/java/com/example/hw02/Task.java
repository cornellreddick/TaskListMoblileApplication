package com.example.hw02;


import java.io.Serializable;

public class Task implements Serializable {
    String taskName;
    String date;
    int priority;

    public Task(String taskName, String date, int priority) {
        this.taskName = taskName;
        this.date = date;
        this.priority = priority;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDate() {
        return date;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return taskName;
    }
}

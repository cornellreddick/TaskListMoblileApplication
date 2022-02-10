package com.example.hw02;

import java.util.ArrayList;
import java.util.Collections;

public class ToDoList {

    private String name;
    private ArrayList<Task> tasks = null;

    public ToDoList(String name){
        this.name = name;
        this.tasks = new ArrayList<Task>();
    }


    public String getName() {
        return name;
    }


    public void addTask(Task task) {
        if(tasks==null){
            this.tasks = new ArrayList<Task>();
        }
        this.tasks.add(task);
    }
}

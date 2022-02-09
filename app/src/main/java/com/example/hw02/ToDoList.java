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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addTask(Task task) {
        if(tasks==null){ //if tasks is null intstantiate it
            this.tasks = new ArrayList<Task>();
        }
        this.tasks.add(task);//then add
    }

    @Override
    public void addTask(String description) {
        if(tasks==null){ //if tasks is null instantitae it
            this.tasks = new ArrayList<Task>();
        }
        Task task = new Task(description);//create task
        this.tasks.add(task);//add it to list

    }

    @Override
    //return highest priority incomplete task
//    public Task getWork() {
//        Task maxTask = null;
//        if(tasks!=null && !tasks.isEmpty()){//if tasks is not null or not empty
//            maxTask = Collections.max(tasks); //get highest priority task from this
//            if(maxTask.isComplete()){ //if the task is complete
//                maxTask = null;//assume there is no other task and return null
//            }
//        }
//
//        return maxTask;
//
//    }

    @Override
    public ArrayList<Task> getTaskList() {
        return tasks;
    }


//    @Override
//    public String toString() {
//        String str = "";
//        str = str.concat("\n--------------");
//        str = str.concat("\nMy ToDo List");
//        str = str.concat("\n--------------");
//
//        for(Task task: tasks){
//            str = str.concat("\n"+task);
//        }
//
//        return str;
//    }

}

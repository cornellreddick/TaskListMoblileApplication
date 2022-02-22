package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hw02.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static public String TAG = "Main";
    final static public String NAME_KEY = "Name";
    final static public String TASK_KEY = "Task";
    final static public String TASKS_KEY = "Tasks";
    final static public String TASKNAME_KEY = "Name: ";
    final static public String DATE_KEY = "Date: ";
    final static public String PRIORITY_KEY = "Priority: ";

    ActivityMainBinding binding;

    public static final int RED_CODE = 100;
    TextView numTasks, currentTask, taskDate, priorityStatus, upcoming, textView;
    ArrayList<Task> tasks;
    ListView lv;
    ArrayAdapter<Task> adapterTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("To Do List");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new ToDoListFragment())
                .addToBackStack(null)
                .commit();





    }
}
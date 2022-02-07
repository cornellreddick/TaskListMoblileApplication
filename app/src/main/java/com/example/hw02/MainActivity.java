package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static public String TAG = "Main";
    final static public String NAME_KEY = "Name";
    final static public String TASK_KEY = "Task";
    final static public String TASKS_KEY = "Tasks";
    final static public String TASKNAME_KEY = "Name: ";
    final static public String DATE_KEY = "Date: ";
    final static public String PRIORITY_KEY = "Priority: ";

    public static final int RED_CODE = 100;
    TextView numTasks, currentTask, taskDate, priorityStatus, upcoming, textView;
    ArrayList<Task> tasks;
    ListView lv;
    ArrayAdapter<Task> adapterTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("To Do List");

//        tasks = new ArrayList<>();
//        tasks.add(new Task("Do Homework", "02/01/2022", 1));
//        tasks.add(new Task("Name of Task 2", "02/01/2022", 2));
//        tasks.add(new Task("Name of Task 3", "02/01/2022", 1));
//        tasks.add(new Task("Name of Task 4", "02/01/2022", 3));
//        tasks.add(new Task("Name of Task 5", "02/01/2022", 1));
//
//
//        currentTask = findViewById(R.id.currentTask);
//        currentTask.setText(String.valueOf(tasks.get(0).taskName));
//
//        numTasks = findViewById(R.id.taskNumber);
//        numTasks.setText(String.valueOf(tasks.size()));
//
//        taskDate = findViewById(R.id.taskDate);
//        taskDate.setText(String.valueOf(tasks.get(0).getDate()));
//
//        priorityStatus = findViewById(R.id.priortyStatus);
//        priorityStatus.setText(String.valueOf(tasks.get(0).getPriority()));

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new ToDoListFragment())
                .commit();

//
//        findViewById(R.id.createTaskButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.containerView, new CreateTaskFragment())
//                        .commit();
//            }
//        });



//        getSupportFragmentManager().beginTransaction()
//                .add()

//        findViewById(R.id.viewTaskButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
//                builderSingle.setTitle("Select Task");
//                //lv = findViewById(R.id.taskListView);
//                adapterTask = new ArrayAdapter<>(MainActivity.this, android.R.layout.select_dialog_item, android.R.id.text1, tasks);
//                builderSingle.setAdapter(adapterTask, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int which) {
//                                Task task = tasks.get(which);
//
//                                String taskName = task.getTaskName();
//                                String date = task.getDate();
//                                int priority = task.getPriority();
//
//                                Bundle b = new Bundle();
//                                b.putString(TASKNAME_KEY, taskName);
//                                b.putString(DATE_KEY, date);
//                                b.putInt(PRIORITY_KEY, priority);
//
//                                Intent intent = new Intent(MainActivity.this, TaskActivity.class);
//                                intent.putExtras(b);
//                                startActivity(intent);
//                            }
//                        });
//                builderSingle.show();
//            }
//        });
    }
}
package com.example.hw02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static public String TAG = "Main";
    final static public String NAME_KEY = "Name";
    final static public String TASK_KEY = "Task";
    final static public String TASKS_KEY = "Tasks";
    TextView numTasks, currentTask, taskDate, priorityStatus;
    ArrayList<Task> tasks;
    ListView lv;
    ArrayAdapter<Task> adapterTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("To Do List");

        tasks = new ArrayList<>();
        tasks.add(new Task("Do Homework", "02/01/2022", 1));
        tasks.add(new Task("Name of Task 2", "02/01/2022", 2));
        tasks.add(new Task("Name of Task 3", "02/01/2022", 1));
        tasks.add(new Task("Name of Task 4", "02/01/2022", 3));
        tasks.add(new Task("Name of Task 5", "02/01/2022", 1));

        lv = findViewById(R.id.taskListView);

        currentTask = findViewById(R.id.currentTask);
        currentTask.setText(String.valueOf(tasks.get(0).taskName));

        numTasks = findViewById(R.id.taskNumber);
        numTasks.setText(String.valueOf(tasks.size()));

        taskDate = findViewById(R.id.taskDate);
        taskDate.setText(String.valueOf(tasks.get(0).getDate()));

        priorityStatus = findViewById(R.id.priortyStatus);
        priorityStatus.setText(String.valueOf(tasks.get(0).getPriority()));


        findViewById(R.id.viewButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                adapterTask = new ArrayAdapter<>(MainActivity.this, android.R.layout.select_dialog_item, android.R.id.text1, tasks);
                builder.setTitle("Select Task");
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setAdapter(adapterTask, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder builderInner = new AlertDialog.Builder(MainActivity.this);
                        builderInner.setTitle("Your Selected Item is");
                        builderInner.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which) {
                                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                        Intent intent = new Intent(MainActivity.this, TaskActivity.class);

                                    }
                                });

                            }
                        });
                        builderInner.show();
                    }
                });
                builder.show();



             //   ArrayAdapter<Task> tasks = new ArrayAdapter<Task>(MainActivity.this, android.R.layout.select_dialog_item, tasks);
//                builder.setMessage(tasks.toString(), );
//                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
////                        Intent intent = new Intent(MainActivity.this, TaskActivity.class);
////                        intent.putExtra(TASK_KEY, new Task("First Task", "02/02/2022", 1));
////
////                        ArrayList<Task> tasks = new ArrayList<>();
////                        tasks.add(new Task("Do Homework", "02/01/2022", 1));
////                        tasks.add(new Task("Name of Task 2", "02/01/2022", 2));
////                        tasks.add(new Task("Name of Task 3", "02/01/2022", 1));
////                        tasks.add(new Task("Name of Task 4", "02/01/2022", 3));
////                        tasks.add(new Task("Name of Task 5", "02/01/2022", 1));
////                        intent.putExtra(TASKS_KEY, tasks);
////                        startActivity(intent);
//                    }
//                });

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: ");
    }
}
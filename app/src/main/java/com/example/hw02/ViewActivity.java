package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    final static public String NAME_KEY = "Name";
    final static public String TASK_KEY = "Task";
    TextView tv;
    String results = "Test";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


//        findViewById(R.id.viewButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               // Intent i = new Intent(ViewActivity.this, TaskActivity.class);
//
//                ArrayList<Task> tasks = new ArrayList<>();
//                tasks.add(new Task("Do Homework"));
//                tasks.add(new Task("Name of Task 2"));
//                tasks.add(new Task("Name of Task 3"));
//                tasks.add(new Task("Name of Task 4"));
//                tasks.add(new Task("Name of Task 5"));
//                AlertDialog.Builder builder = new AlertDialog.Builder(ViewActivity.this);
//                builder.setTitle("Select Task");
//                builder.setItems(tasks.toArray(new String[0]), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//               // i.putExtra(TASK_KEY, tasks);
//
//            }
//        });

//        ArrayAdapter<Task> tasks = new ArrayAdapter<>(ViewActivity.this, android.R.layout.select_dialog_item);
//        tasks.add(new Task("Do Homework"));
//        tasks.add(new Task("Name of Task 2"));
//        tasks.add(new Task("Name of Task 3"));
//        tasks.add(new Task("Name of Task 4"));
//        tasks.add(new Task("Name of Task 5"));
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(ViewActivity.this);
//        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        builder.setAdapter(tasks, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Task task = tasks.getItem(which);
//                AlertDialog.Builder builderInner = new AlertDialog.Builder(ViewActivity.this);
//                builderInner.setMessage(task.taskName);
//                builderInner.setTitle("Your Selected Item is");
//                builderInner.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog,int which) {
//                        Intent i = new Intent(ViewActivity.this, TaskActivity.class);
//                        i.putExtra(TASK_KEY, new Task("test"));
//                        startActivity(i);
//
//                    }
//                });
//
//
//
//                builderInner.show();
//            }
//        });
//        builder.show();

    }
}
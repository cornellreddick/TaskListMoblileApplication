package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TaskActivity extends AppCompatActivity {
    TextView tv, date, priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        tv = findViewById(R.id.textViewName);
        date = findViewById(R.id.textViewDate);
        priority = findViewById(R.id.textViewStatus);

      if (getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(MainActivity.TASKS_KEY)){
          //String name = getIntent().getStringExtra(MainActivity.NAME_KEY);
          //Task task = (Task) getIntent().getSerializableExtra(MainActivity.TASK_KEY);

          ArrayList<Task> tasks = ( ArrayList<Task>) getIntent().getSerializableExtra(MainActivity.TASKS_KEY);
          Collections.shuffle(tasks);
          Task task = tasks.get(0);
          tv.setText(task.taskName);
          date.setText(task.date);
          priority.setText(String.valueOf(task.priority));

      }

      findViewById(R.id.taskCancelButton).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(TaskActivity.this, MainActivity.class);
              startActivity(intent);
          }
      });

    }

}

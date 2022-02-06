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
    TextView tvName, tvDate, tvPriority;
    final static public String NAME_KEY = "Name";
    Bundle bundle;
   ArrayList<Task> tasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        tvName = findViewById(R.id.textViewName);
        tvDate = findViewById(R.id.textViewDate);
        tvPriority = findViewById(R.id.textViewStatus);

        Bundle b = getIntent().getExtras();
        String taskName = b.getString(MainActivity.TASKNAME_KEY);
        String date = b.getString(MainActivity.DATE_KEY);
        int priority = b.getInt(MainActivity.PRIORITY_KEY);

        tvName.setText(MainActivity.TASKNAME_KEY + taskName);
        tvDate.setText(MainActivity.DATE_KEY + date);
        tvPriority.setText(MainActivity.PRIORITY_KEY + priority);

      findViewById(R.id.taskCancelButton).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(TaskActivity.this, MainActivity.class);
              startActivity(intent);
          }
      });

    }
}

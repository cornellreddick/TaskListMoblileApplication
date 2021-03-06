package com.example.hw02;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class TaskActivity extends AppCompatActivity {
    TextView tvName, tvDate, tvPriority;
    final static public String NAME_KEY = "Name";
    Bundle bundle;
    ArrayList<Task> tasks;
    public static ArrayAdapter<Task> adapterTask;
    ListView lv;
    public static int deletePos;

    @RequiresApi(api = Build.VERSION_CODES.N)
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

        findViewById(R.id.taskDeleteButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int d = ToDoListFragment.deletePos;
                ToDoListFragment.tasks.remove(d);
                ToDoListFragment.adapterTask.notifyDataSetChanged();
            Intent intent = new Intent(TaskActivity.this, ToDoListFragment.class);
                startActivity(intent);

            }
        });

    }


}

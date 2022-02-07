package com.example.hw02;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;


public class ToDoListFragment extends Fragment {
    final static public String TAG = "Main";
    final static public String NAME_KEY = "Name";
    final static public String TASK_KEY = "Task";
    final static public String TASKS_KEY = "Tasks";
    final static public String TASKNAME_KEY = "Name: ";
    final static public String DATE_KEY = "Date: ";
    final static public String PRIORITY_KEY = "Priority: ";
    TextView numTasks, currentTask, taskDate, priorityStatus, upcoming, textView;
    ArrayList<Task> tasks;
    ListView lv;
    ArrayAdapter<Task> adapterTask;


    public ToDoListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        tasks = new ArrayList<>();
        tasks.add(new Task("Do Homework", "02/01/2022",1));
        tasks.add(new Task("Name of Task 2", "02/02/2022", 2));
        tasks.add(new Task("Name of Task 3", "02/03/2022", 1));
        tasks.add(new Task("Name of Task 4", "02/04/2022", 3));
        tasks.add(new Task("Name of Task 5", "02/05/2022", 1));



        currentTask = view.findViewById(R.id.currentTask);
        currentTask.setText(String.valueOf(tasks.get(0).taskName));

        numTasks = view.findViewById(R.id.taskNumber);
        numTasks.setText(String.valueOf(tasks.size()));

        taskDate = view.findViewById(R.id.taskDate);
        taskDate.setText(String.valueOf(tasks.get(0).getDate()));

        priorityStatus = view.findViewById(R.id.priortyStatus);
        priorityStatus.setText(String.valueOf(tasks.get(0).getPriority()));

                view.findViewById(R.id.viewTaskButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(getActivity());
                builderSingle.setTitle("Select Task");
                builderSingle.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                //lv = findViewById(R.id.taskListView);
                adapterTask = new ArrayAdapter<>(getActivity(), android.R.layout.select_dialog_item, android.R.id.text1, tasks);
                builderSingle.setAdapter(adapterTask, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                Task task = tasks.get(which);

                                String taskName = task.getTaskName();
                                String date = task.getDate();
                                int priority = task.getPriority();

                                Bundle b = new Bundle();
                                b.putString(TASKNAME_KEY, taskName);
                                b.putString(DATE_KEY, date);
                                b.putInt(PRIORITY_KEY, priority);

                                Intent intent = new Intent(getActivity(), TaskActivity.class);
                                intent.putExtras(b);
                                startActivity(intent);
                            }
                        });
                builderSingle.show();
            }
        });

                view.findViewById(R.id.createTaskButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.containerView, new CreateTaskFragment())
                                .commit();
                    }
                });


        return  view;
    }
}
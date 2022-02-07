package com.example.hw02;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class CreateTaskFragment extends Fragment {

    DatePickerDialog dp;
    TextView tvDate;
    int year;
    int month;
    int day;
    ArrayList<Task> tasks;
    ListView lv;
    ArrayAdapter<Task> adapterTask;
    EditText editText;
    RadioGroup radioGroup;
    public CreateTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Calendar myCalendar= Calendar.getInstance();
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_create_task, container, false);
      tvDate = view.findViewById(R.id.testDAte);
      view.findViewById(R.id.setDateButton).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
             Calendar calendar = Calendar.getInstance();
              month = calendar.get(Calendar.MONTH);
              day = calendar.get(Calendar.DAY_OF_MONTH);
              year = calendar.get(Calendar.YEAR);
              DatePickerDialog dp = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    tvDate.setText(month + "/" + day + "/" + year);
                }
            }, 2022, 2, 1);
             dp.show();
          }
      });

    view.findViewById(R.id.createTaskCancelButton).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new ToDoListFragment())
                    .commit();
        }
    });
        view.findViewById(R.id.createCancelSubmitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText = editText.findViewById(R.id.createName);
                String taskName = editText.getText().toString();
//
//                radioGroup = radioGroup.findViewById(R.id.radioGroup).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
  //              });

                Task task = new Task(taskName,tvDate.toString(),1  );
                ToDoListFragment.tasks.add(task);
//                        tasks = new ArrayList<>();
//                        String taskName = task.getTaskName();
//                        String date = task.getDate();
//                        int priority = task.getPriority();
//
//                        Bundle b = new Bundle();
//                        b.putString(ToDoListFragment.TASKNAME_KEY, taskName);
//                        b.putString(ToDoListFragment.DATE_KEY, date);
//                        b.putInt(ToDoListFragment.PRIORITY_KEY, priority);
//
//                        Intent intent = new Intent(getActivity(), TaskActivity.class);
//                        intent.putExtras(b);
//                        startActivity(intent);
            }
        });


      return  view;
    }

}
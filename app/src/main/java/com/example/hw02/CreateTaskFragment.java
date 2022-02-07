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
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class CreateTaskFragment extends Fragment {

    DatePickerDialog dp;
    TextView tvDate;
    int year;
    int month;
    int dayOfMonth;
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
              year = calendar.get(Calendar.YEAR);
              DatePickerDialog dp = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    tvDate.setText(day + "/" + month + "/" + year);
                }
            }, 0, 0, 0);
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
                Intent addTask = new Intent(getActivity(), ToDoListFragment.class);
                int requestCode = 1;
                startActivityForResult(addTask, requestCode);
            }
        });


      return  view;
    }

}
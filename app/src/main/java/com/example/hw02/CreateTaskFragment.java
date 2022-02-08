package com.example.hw02;

import android.app.DatePickerDialog;
import android.content.Intent;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateTaskFragment extends Fragment {

    DatePickerDialog dp;
    TextView tvDate;
    int year;
    int month;
    int day;
    String userInput;
    ArrayList<Task> tasks;
    ListView lv;
    ArrayAdapter<Task> adapterTask;
    EditText editText;
    RadioGroup radioGroup;
    RadioButton radioButton;
    int radioButtonCheck;
    int Results;
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
        View view = inflater.inflate(R.layout.fragment_create_task, container, false);

        view.findViewById(R.id.createSubmitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        editText = (EditText) view.findViewById(R.id.createName);
        editText.getText().toString();



        radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                 radioButtonCheck = radioGroup.getCheckedRadioButtonId();

                    if (checked == R.id.high) {
                        Results = 3;
                    } else if (checked == R.id.medium) {
                        Results = 2;
                    } else if (checked == R.id.low) {
                        Results = 1;
                    } else {
                        Toast.makeText(getContext(), "Please Select a radio button!", Toast.LENGTH_SHORT).show();
                    }

            }
        });

        final Calendar myCalendar= Calendar.getInstance();
        // Inflate the layout for this fragment

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
        view.findViewById(R.id.createSubmitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText.getText().toString().matches("") || tvDate.getText().toString().matches("") || radioGroup.getCheckedRadioButtonId() == -1 ) {
                    Toast.makeText(getActivity(), "Please select date, radio button, or add Task name!!", Toast.LENGTH_SHORT).show();
                }else
                {
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new ToDoListFragment())
                            .commit();
                }

                tasks = new ArrayList<>();
                tasks.add(new Task(editText.toString(),tvDate.toString(), Results ));

            }
        });


      return  view;
    }

}
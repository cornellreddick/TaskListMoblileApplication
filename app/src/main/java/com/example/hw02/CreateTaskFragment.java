package com.example.hw02;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import com.example.hw02.databinding.FragmentCreateTaskBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateTaskFragment extends Fragment implements ToDoListFragment.AddItem {
    FragmentCreateTaskBinding binding;
    final static public String CREATE_TASKNAME_KEY = "Name";
    final static public String CREATE_DATE_KEY = "Date";
    final static public String CREATE_PRIORITY_KEY = "Priority";
    DatePickerDialog dp;
    TextView tvDate,  priority;
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
    int results;
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
        //View view = inflater.inflate(R.layout.fragment_create_task, container, false);
        binding = FragmentCreateTaskBinding.inflate(inflater, container, false);
        editText = binding.createName;
        radioGroup = binding.radioGroup;
        tvDate = binding.testDAte;
        priority = binding.priority;

        binding.createTaskCancelButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new ToDoListFragment()).addToBackStack(null)
                    .commit();
        }
    });
        binding.setDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                year = calendar.get(Calendar.YEAR);
                DatePickerDialog dp = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                tvDate.setText(month +1 + "/" + day + "/" + year);
                            }
                        },
                        2022,
                        2,
                        1);
                dp.show();
            }
        });
        binding.createSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checked = radioGroup.getCheckedRadioButtonId();
                int result = 0;
                int value = 0;
                if (checked == R.id.high) {
                    value = 3;
                    result = value;
                } else if (checked == R.id.medium) {
                    value = 2;
                    result = value;
                } else if (checked == R.id.low) {
                    value = 1;
                    result = value;
                } else {
                    Toast.makeText(getActivity(), "Please Select a radio button!", Toast.LENGTH_SHORT).show();
                }


                if (tvDate.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Please select date!!", Toast.LENGTH_SHORT).show();

                }
                else if ( editText.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Please select Task name!!", Toast.LENGTH_SHORT).show();
                }else
                {
                    String date = tvDate.getText().toString();
                    String taskName = editText.getText().toString();
                    int priority = result;


                    CreateTaskFragment createTaskFragment = new CreateTaskFragment();
                    Bundle b = new Bundle();
                    b.putString(CREATE_TASKNAME_KEY, taskName);
                    b.putString(CREATE_DATE_KEY, date);
                    b.putInt(CREATE_PRIORITY_KEY, priority);
                    createTaskFragment.setArguments(b);

                    addToList(taskName, date, priority);


                    tasks.add(new Task(taskName, date, priority));

                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new ToDoListFragment())
                            .addToBackStack(null)
                            .commit();
                }

            }
        });



      return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    ToDoListFragment.AddItem addItem;
    @Override
    public void addToList(String name, String date, int prority) {
        tasks.add(new Task(name, date, prority));
        adapterTask.notifyDataSetChanged();

    }
}

package com.example.roomdatabasewithjaba.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.roomdatabasewithjaba.Database.Employee;
import com.example.roomdatabasewithjaba.Database.MyViewModel;
import com.example.roomdatabasewithjaba.Database.Salary;
import com.example.roomdatabasewithjaba.databinding.ActivitySalaryAdderBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SalaryAdder extends AppCompatActivity {
ActivitySalaryAdderBinding binding;
    DatePickerDialog picker;
    Calendar SelectedDate;
    MyViewModel myViewModel;
    EmployeSpinedAdpater adpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySalaryAdderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myViewModel=new ViewModelProvider(this).get(MyViewModel.class);

        binding.dateadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(SalaryAdder.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                binding.dateadd.setText(dayOfMonth + "/" + (monthOfYear) + "/" + year);
                                SelectedDate = Calendar.getInstance();
                                SelectedDate.set(Calendar.YEAR,year);
                                SelectedDate.set(Calendar.MONTH,monthOfYear);
                                SelectedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();

            }
        });

        adpater = new EmployeSpinedAdpater(new ArrayList<>());
        binding.spinnerT.setAdapter(adpater);
        myViewModel.GetlAlluser().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                adpater.setEmployees(employees);
            }
        });
        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Salarye=binding.SalarText.getText().toString();
                long EmplId=binding.spinnerT.getSelectedItemId();
                if(TextUtils.isEmpty(Salarye)|| SelectedDate==null)
                {
                    Toast.makeText(SalaryAdder.this,"Plase Fill All Data",Toast.LENGTH_SHORT).show();
                    return;
                }
                double amount = Double.parseDouble(Salarye);
                Salary salary = new Salary(EmplId,SelectedDate.getTime(),amount);
                myViewModel.InsetSalary(salary);
                finish();
            }
        });
    }
}
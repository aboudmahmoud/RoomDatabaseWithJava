package com.example.roomdatabasewithjaba.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.roomdatabasewithjaba.Database.Employee;
import com.example.roomdatabasewithjaba.databinding.ActivityEmployBinding;

import java.util.Calendar;

public class EmployActivity extends AppCompatActivity {
ActivityEmployBinding binding;
    DatePickerDialog picker;
    Calendar SelectedDate;
    public static String EmployeKey="EmployerKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEmployBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.Inserted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =binding.Name.getText().toString();
                String Email =binding.Emailtext.getText().toString();
                String id =binding.IDtext.getText().toString();
                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(Email)||TextUtils.isEmpty(id)||SelectedDate==null)
                {
                    Toast.makeText(EmployActivity.this,"plase Dont Let Antyting Empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                long ide= Long.parseLong(id);
                binding.datepiker.setText("Entar Brith Date");
                Employee employee= new Employee(ide,name,Email,SelectedDate.getTime());
                Intent intent = new Intent();
                intent.putExtra(EmployeKey,employee);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        binding.datepiker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(EmployActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                binding.datepiker.setText(dayOfMonth + "/" + (monthOfYear) + "/" + year);
                                SelectedDate = Calendar.getInstance();
                                SelectedDate.set(Calendar.YEAR,year);
                                SelectedDate.set(Calendar.MONTH,monthOfYear);
                                SelectedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();

            }
        });


    }
}
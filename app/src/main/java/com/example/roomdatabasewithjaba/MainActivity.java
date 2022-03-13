package com.example.roomdatabasewithjaba;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.roomdatabasewithjaba.Database.Employee;
import com.example.roomdatabasewithjaba.Database.MyViewModel;
import com.example.roomdatabasewithjaba.Views.EmployActivity;
import com.example.roomdatabasewithjaba.Views.EmploySalaryAdpabter;
import com.example.roomdatabasewithjaba.Views.SalaryAdder;
import com.example.roomdatabasewithjaba.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

ActivityMainBinding binding;
MyViewModel myViewModel;
    EmploySalaryAdpabter adpabter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myViewModel=new ViewModelProvider(this).get(MyViewModel.class);
        adpabter = new EmploySalaryAdpabter(new ArrayList<>(),myViewModel);
        binding.Rv.setAdapter(adpabter);
        binding.Rv.setHasFixedSize(true);
        binding.Rv.setLayoutManager(new LinearLayoutManager(this));
        myViewModel.GetlAlluser().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
              adpabter.setEmployees(employees);
            }
        });

        ActivityResultLauncher<Intent>  activityResultLauncher= registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==RESULT_OK&& result.getData()!=null)
                        {
                            Employee employee= (Employee) result.getData().getSerializableExtra(EmployActivity.EmployeKey);
                            myViewModel.InsertEmployee(employee);
                        }
                    }
                });

        binding.FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(getBaseContext(), EmployActivity.class);
                activityResultLauncher.launch(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_salaary,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.addSalary:
                Intent intent = new Intent(this, SalaryAdder.class);
                startActivity(intent);
                return true;
        }
        return false;
    }
}
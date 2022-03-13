package com.example.roomdatabasewithjaba.Views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabasewithjaba.Database.DoubleValueListner;
import com.example.roomdatabasewithjaba.Database.Employee;
import com.example.roomdatabasewithjaba.Database.MyViewModel;
import com.example.roomdatabasewithjaba.R;
import com.example.roomdatabasewithjaba.databinding.CoustemSalaryEmployeBinding;

import java.util.List;

public class EmploySalaryAdpabter extends RecyclerView.Adapter<EmploySalaryAdpabter.EmploySalaryHolder> {
    private List<Employee> employees;
    private  MyViewModel mvm;

    public EmploySalaryAdpabter(List<Employee> employees, MyViewModel mvm) {
        this.employees = employees;
        this.mvm = mvm;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmploySalaryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmploySalaryHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coustem_salary_employe,parent,false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull EmploySalaryHolder holder, int position) {
      Employee employee= employees.get(position);
      holder.bind(employee,mvm);

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class EmploySalaryHolder extends RecyclerView.ViewHolder{
CoustemSalaryEmployeBinding binding;
Employee employee;
        public EmploySalaryHolder(@NonNull View itemView) {
            super(itemView);
            binding=CoustemSalaryEmployeBinding.bind(itemView);
        }

        void bind(Employee employee, MyViewModel mvm)
        {
            this.employee=employee;
            binding.EmployeName.setText(employee.getName());
            mvm.GetSalarySums(employee.getID(), new DoubleValueListner() {
                @Override
                public void OnValueSumbit(Double value) {
                    binding.EmployerSalary.setText(value+"$");
                }
            });
        }
    }
}

package com.example.roomdatabasewithjaba.Views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.roomdatabasewithjaba.Database.Employee;
import com.example.roomdatabasewithjaba.R;

import java.util.List;

public class EmployeSpinedAdpater  extends BaseAdapter {
    private List<Employee> employees;

    public EmployeSpinedAdpater(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return employees.size() ;
    }

    @Override
    public Employee getItem(int i) {
        return employees.get(i);
    }

    @Override
    public long getItemId(int i) {
        return  employees.get(i).getID();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=view;
        if (v==null)
        {
            v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spriner_coustem_employer_names,null,false);
        }
        TextView tv=v.findViewById(R.id.EmplyesNames);
        Employee employee = getItem(i);
        tv.setText(employee.getName());
        return v;
    }
}

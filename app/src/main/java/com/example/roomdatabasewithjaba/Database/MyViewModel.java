package com.example.roomdatabasewithjaba.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

public class MyViewModel extends AndroidViewModel {
    Reporstory reporstory;

    public MyViewModel(@NonNull Application application) {
        super(application);
        reporstory=new Reporstory(application);
    }

    //EmployeeMethod
    public void InsertEmployee(Employee... employee) {
        reporstory.InsertEmployee(employee);
    }


    public void UpdateEmployee(Employee... employee) {
        reporstory.UpdateEmployee(employee);
    }


    public void DeleteEmployee(Employee... employees) {
        reporstory.DeleteEmployee(employees);
    }


    public void DeletByEmail(String Email) {
        reporstory.DeletByEmail(Email);
    }

    public LiveData<List<Employee>> GetlAlluser() {
        return reporstory.GetlAlluser();
    }

    public LiveData<List<Employee>> GetlAlluserByEmail(String Email) {
        return reporstory.GetlAlluserByEmail(Email);
    }

    public LiveData<List<Employee>> GetlAlluserByName(String Name) {
        return reporstory.GetlAlluserByName(Name);
    }

    //SalarryDaoMethod

    public void InsetSalary(Salary salary) {
        reporstory.InsetSalary(salary);
    }

    public void UpdateSalary(Salary salary) {
        reporstory.UpdateSalary(salary);
    }

    public void DeleteSalary(Salary salary) {
        reporstory.DeleteSalary(salary);
    }

    public LiveData<List<Salary>> getEmployeeSalaries(long emp_id) {
        return reporstory.getEmployeeSalaries(emp_id);
    }

    public LiveData<List<Salary>> getEmployeeSalaries(long emp_id, Date form, Date To) {
        return reporstory.getEmployeeSalaries(emp_id, form, To);
    }

    public LiveData<List<Salary>> getEmployeeSalaries(Date form, Date To) {
        return reporstory.getEmployeeSalaries(form, To);
    }

    public void GetSalarySums(long emp_id, DoubleValueListner listner) {
        reporstory.GetSalarySums(emp_id,listner);
    }

}

package com.example.roomdatabasewithjaba.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

public class Reporstory {
    EmployeeDAO employeeDAO;
    SalaryDAO salaryDAO;

    public Reporstory(Application application) {
        //That Code Can Work in main Activity
        MyRoomDataBase dp = MyRoomDataBase.getDatabase(application);
        employeeDAO = dp.employeeDAO();
        salaryDAO = dp.salaryDAO();
    }


    //EmployeeMethod
    public void InsertEmployee(Employee... employee) {
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDAO.InsertEmployee(employee);
            }
        });
    }


    public void UpdateEmployee(Employee... employee) {
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDAO.UpdateEmployee(employee);
            }
        });
    }


    public void DeleteEmployee(Employee... employees) {
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDAO.DeleteEmployee(employees);
            }
        });
    }


    public void DeletByEmail(String Email) {
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDAO.DeletByEmail(Email);
            }
        });
    }

    public LiveData<List<Employee>> GetlAlluser() {
        return employeeDAO.GetlAlluser();
    }

    public LiveData<List<Employee>> GetlAlluserByEmail(String Email) {
        return employeeDAO.GetlAlluserByEmail(Email);
    }

    public LiveData<List<Employee>> GetlAlluserByName(String Name) {
        return employeeDAO.GetlAlluserByName(Name);
    }

    //SalarryDaoMethod

    public void InsetSalary(Salary salary) {
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                salaryDAO.InsetSalary(salary);
            }
        });
    }

    public void UpdateSalary(Salary salary) {
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                salaryDAO.UpdateSalary(salary);
            }
        });
    }

    public void DeleteSalary(Salary salary) {
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                salaryDAO.DeleteSalary(salary);
            }
        });
    }

    public LiveData<List<Salary>> getEmployeeSalaries(long emp_id) {
        return salaryDAO.getEmployeeSalaries(emp_id);
    }

    public LiveData<List<Salary>> getEmployeeSalaries(long emp_id, Date form, Date To) {
        return salaryDAO.getEmployeeSalaries(emp_id, form, To);
    }

    public LiveData<List<Salary>> getEmployeeSalaries(Date form, Date To) {
        return salaryDAO.getEmployeeSalaries(form, To);
    }

    public void GetSalarySums(long emp_id, DoubleValueListner listner) {
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                double value = salaryDAO.GetSalarySums(emp_id);
                listner.OnValueSumbit(value);
            }
        });
    }


}

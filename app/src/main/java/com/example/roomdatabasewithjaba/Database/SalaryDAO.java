package com.example.roomdatabasewithjaba.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

@Dao
@TypeConverters({DateConverter.class})
public interface SalaryDAO {
    @Insert
    void InsetSalary(Salary salary);
    @Update
    void UpdateSalary(Salary salary);
    @Delete
    void DeleteSalary(Salary salary);

    @Query("select * from Salary where EmployerID=:emp_id order by date desc")
    LiveData<List<Salary>> getEmployeeSalaries(long emp_id);
    @Query("select * from Salary where EmployerID=:emp_id and date>=:form AND date<=:To order by date desc")
    LiveData<List<Salary>> getEmployeeSalaries(long emp_id, Date form,Date To);
    @Query("select * from Salary where  date>=:form AND date<=:To order by date desc")
    LiveData<List<Salary>> getEmployeeSalaries( Date form,Date To);

    @Query("select sum(amount) from salary where  employerID=:emp_id")
    double GetSalarySums(long emp_id);

    @Query("select sum(salary.amount) as _salary , EmployeeTable.Name as _Name from salary " +
            "INNER join EmployeeTable ON salary.EmployerID=EmployeeTable.ID group by name")
    LiveData<List<EmployeeSalary>> GetSalarySums();



}

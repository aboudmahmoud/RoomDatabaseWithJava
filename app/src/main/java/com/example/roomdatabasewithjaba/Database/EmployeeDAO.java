package com.example.roomdatabasewithjaba.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import java.util.List;

//DAO Data Access Object
@Dao
@TypeConverters({DateConverter.class})
public interface EmployeeDAO {
    @Insert
    void InsertEmployee(Employee... employee);

    @Update
    void UpdateEmployee(Employee... employee);

    @Delete
    void DeleteEmployee(Employee... employees);

    @Query("delete from EmployeeTable where email=:Email")
      void DeletByEmail(String Email);

    @Query("select * from EmployeeTable order by name asc")
    LiveData<List<Employee>>GetlAlluser();

    @Query("select * from EmployeeTable where email=:Email")
    LiveData<List<Employee>>GetlAlluserByEmail(String Email);

    @Query("select * from EmployeeTable where name like '%'||:Name||'%'")
    LiveData<List<Employee>>GetlAlluserByName(String Name);


}

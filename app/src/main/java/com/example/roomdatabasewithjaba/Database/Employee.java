package com.example.roomdatabasewithjaba.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.Date;

@Entity (tableName = "EmployeeTable")
@TypeConverters({DateConverter.class})
public class Employee implements Serializable {
    //Employee {id,name,date,email}
    @PrimaryKey
    @NonNull
    private long ID ;
    @NonNull
    private String Name;
    @NonNull
    private String Email;

    private Date date;

    public Employee() {
    }

    public Employee(long ID, String name, String email, Date date) {
        this.ID = ID;
        Name = name;
        Email = email;
        this.date = date;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

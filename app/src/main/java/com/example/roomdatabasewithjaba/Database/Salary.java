package com.example.roomdatabasewithjaba.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.Date;

@Entity(foreignKeys = {@ForeignKey(entity = Employee.class,parentColumns = {"ID"}
        ,childColumns = {"EmployerID"},onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE)})
@TypeConverters({DateConverter.class})
public class Salary implements Serializable {
    //Salary {id,amount,date,EmplyID}
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private long EmployerID;
    @NonNull
    private Date date;
    @NonNull
    private Double amount;

    public Salary() {
    }

    public Salary(int id, long employerID, @NonNull Date date, @NonNull Double amount) {
        this.id = id;
        EmployerID = employerID;
        this.date = date;
        this.amount = amount;
    }

    public Salary(long employerID, @NonNull Date date, @NonNull Double amount) {
        EmployerID = employerID;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getEmployerID() {
        return EmployerID;
    }

    public void setEmployerID(long employerID) {
        EmployerID = employerID;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @NonNull
    public Double getAmount() {
        return amount;
    }

    public void setAmount(@NonNull Double amount) {
        this.amount = amount;
    }
}

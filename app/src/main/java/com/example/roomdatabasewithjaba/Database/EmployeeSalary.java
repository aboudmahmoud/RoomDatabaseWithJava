package com.example.roomdatabasewithjaba.Database;

public class EmployeeSalary {
    private String _Name;
    private  double _salary;

    public EmployeeSalary() {
    }

    public EmployeeSalary(String name, double salary) {
        _Name = name;
        this._salary = salary;
    }

    public String getName() {
        return _Name;
    }

    public void setName(String _Name) {
        this._Name = _Name;
    }

    public double getsalary() {
        return _salary;
    }

    public void setsalary(double _salary) {
        this._salary = _salary;
    }
}

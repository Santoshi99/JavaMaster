package org.example;

public class Employee {
    private int empId;
    private String empName;
    private String designation;
    private int salary;
    private Shift shift;
    private int experience;

    public Employee() {
    }

    public Employee(Shift shift, int empId, String empName, String designation, int salary, int experience) {
        this.shift = shift;
        this.empId = empId;
        this.empName = empName;
        this.designation = designation;
        this.salary = salary;
        this.experience = experience;
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}

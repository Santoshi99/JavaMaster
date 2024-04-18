package org.example;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    private List<Employee> employees;
    public List<Employee> getEmployees(){
        return employees;
    }
    public void generateEmployees(){
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(Shift.AMR,1,"Raj","Manager",110000,12);
        Employee emp2 = new Employee(Shift.India,2,"Swetha","Analyst",60000,6);
        Employee emp3 = new Employee(Shift.EMEA,3,"Vikram","System Engineer",30000,2);
        Employee emp4 = new Employee(Shift.AMR,4,"Jyothi","Team Lead",90000,8);
        Employee emp5 = new Employee(Shift.APAC,5,"Prem","Analyst",68000,5);
        Employee emp6 = new Employee(Shift.EMEA,6,"Lakshmi","Team Lead",750000,10);
        Employee emp7 = new Employee(Shift.India,7,"Kiran","Manager",130000,15);
        Employee emp8 = new Employee(Shift.AMR,8,"Keerti","Consultant",50000,6);
        Employee emp9 = new Employee(Shift.APAC,9,"Karan","Associate Engineer",80000,9);
        Employee emp10 = new Employee(Shift.India,10,"Navya","System Engineer",40000,3);
        Employee emp11 = new Employee(Shift.EMEA,11,"Jhansi","Consultant",40000,5);
        Employee emp12 = new Employee(Shift.AMR,12,"Prasad","Associate Engineer",70000,7);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);
        employees.add(emp7);
        employees.add(emp8);
        employees.add(emp9);
        employees.add(emp10);
        employees.add(emp11);
        employees.add(emp12);
        this.employees = employees;
    }


}

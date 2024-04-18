package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      Organization organization = new Organization();
      organization.generateEmployees();
       List<Employee> employees = organization.getEmployees();

       //print all employees whose salary > 1L
       employees.stream().filter((emp)->emp.getSalary()>100000).map(Employee::getEmpName).forEach(System.out::println);

       // List all employees who are working in AMR shift
        System.out.println("Employees working in AMR shift");
        List<Employee> employeesInAMR = employees.stream().filter(emp-> emp.getShift()==Shift.AMR).toList();
        Iterator<Employee> iter = employeesInAMR.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().getEmpName());
        }

        //total number of unique experience
       long count =  employees.stream().map(Employee::getExperience).distinct().count();
        System.out.println("unique "+count);

        // allMatch salary

       boolean result =  employees.stream().allMatch(emp->emp.getSalary()>50000);
       System.out.println(result);

       //
       OptionalDouble avg =  employees.stream().mapToDouble(emp -> emp.getEmpName().length()).average();
       if(avg.isPresent()) System.out.println(avg);


    }
}
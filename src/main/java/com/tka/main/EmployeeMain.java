package com.tka.main;

import java.util.List;
import java.util.Arrays;

import com.tka.dao.EmployeeDAO;
import com.tka.daoImpl.EmployeeDaoImpl;
import com.tka.entity.Employee;

public class EmployeeMain {

    public static void main(String[] args) {

        EmployeeDAO employeedao = new EmployeeDaoImpl();

        List<Employee> employee_list;

        /*
        employee_list = employeedao.searchEmployeeByDepartment("IT");
        employee_list.forEach(e -> System.out.println(e));

        employee_list = employeedao.searchEmployeeAboveSalary(50000.0);
        employee_list.forEach(e -> System.out.println(e));

        employee_list = employeedao.searchEmployeeUnderSalary(50000.0);
        employee_list.forEach(e -> System.out.println(e));

        employee_list = employeedao.searchEmployeeByDepartmentNotEqual("HR");
        employee_list.forEach(e -> System.out.println(e));

        employee_list = employeedao.searchEmployeeSalary(40000.0);
        employee_list.forEach(e -> System.out.println(e));

        List<String> names = Arrays.asList("Rahul", "Priya");
        employee_list = employeedao.searchEmployeeByName(names);
        employee_list.forEach(e -> System.out.println(e));

        employee_list = employeedao.searchEmployeeByNameAndSalary("Rahul", 50000);
        employee_list.forEach(e -> System.out.println(e));

        employee_list = employeedao.searchEmployeeNameStartWith("A");
        employee_list.forEach(e -> System.out.println(e));

        employee_list = employeedao.getEmployeeListBySalary(30000);
        employee_list.forEach(e -> System.out.println(e));

        employee_list = employeedao.getEmployeeList();
        employee_list.forEach(e -> System.out.println(e));
        */

        System.out.println("Highest Salary: " + employeedao.getHighestSalaryEmployee());
        System.out.println("Lowest Salary: " + employeedao.getLowestSalaryEmployee());
        System.out.println("Second Highest Salary: " + employeedao.getSecondHighestSalaryEmployee());
        System.out.println("Second Lowest Salary: " + employeedao.getSecondLowestSalaryEmployee());
    }
}
package com.tka.dao;

import java.util.List;
import com.tka.entity.Employee;

public interface EmployeeDAO {

    public void insertEmployee(Employee employee);

    public List<Employee> searchEmployeeByDepartment(String department);

    public List<Employee> searchEmployeeAboveSalary(Double salary);

    public List<Employee> searchEmployeeUnderSalary(Double salary);

    public List<Employee> searchEmployeeByDepartmentNotEqual(String department);

    public List<Employee> searchEmployeeSalary(Double salary);

    public List<Employee> searchEmployeeByName(List<String> names);

    public List<Employee> searchEmployeeBySalaryNotInRange(double min, double max);

    public List<Employee> searchEmployeeBySalaryNotInRangeList(List<Double> salaries);

    public List<Employee> searchEmployeeByNameAndSalary(String name, double salary);

    public List<Employee> searchEmployeeNameStartWith(String name);

    public List<Employee> getEmployeeListBySalary(double salary);

    public List<Employee> getEmployeeList();

    public Employee getHighestSalaryEmployee();

    public Employee getLowestSalaryEmployee();

    public Employee getSecondHighestSalaryEmployee();

    public Employee getSecondLowestSalaryEmployee();
}
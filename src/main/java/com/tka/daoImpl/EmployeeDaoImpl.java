package com.tka.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;

import com.tka.dao.EmployeeDAO;
import com.tka.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {

    private Session getSession() {
        return new Configuration().configure()
                .buildSessionFactory().openSession();
    }

    public void insertEmployee(Employee employee) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee);

        transaction.commit();
        session.close();
        System.out.println("Employee Data Saved...");
    }

    public List<Employee> searchEmployeeByDepartment(String department) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.eq("department", department)).list();
        session.close();
        return list;
    }

    public List<Employee> searchEmployeeAboveSalary(Double salary) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.gt("salary", salary)).list();
        session.close();
        return list;
    }

    public List<Employee> searchEmployeeUnderSalary(Double salary) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.le("salary", salary)).list();
        session.close();
        return list;
    }

    public List<Employee> searchEmployeeByDepartmentNotEqual(String department) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.ne("department", department)).list();
        session.close();
        return list;
    }

    public List<Employee> searchEmployeeSalary(Double salary) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.ge("salary", salary)).list();
        session.close();
        return list;
    }

    public List<Employee> searchEmployeeByName(List<String> names) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.in("name", names)).list();
        session.close();
        return list;
    }

    public List<Employee> searchEmployeeBySalaryNotInRange(double min, double max) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.not(Restrictions.between("salary", min, max))).list();
        session.close();
        return list;
    }

    public List<Employee> searchEmployeeBySalaryNotInRangeList(List<Double> salaries) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.not(Restrictions.in("salary", salaries))).list();
        session.close();
        return list;
    }

    public List<Employee> searchEmployeeByNameAndSalary(String name, double salary) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.and(
                        Restrictions.eq("name", name),
                        Restrictions.ge("salary", salary))).list();
        session.close();
        return list;
    }

    public List<Employee> searchEmployeeNameStartWith(String name) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.like("name", name + "%")).list();
        session.close();
        return list;
    }

    public List<Employee> getEmployeeListBySalary(double salary) {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .add(Restrictions.ge("salary", salary))
                .addOrder(Order.asc("salary")).list();
        session.close();
        return list;
    }

    public List<Employee> getEmployeeList() {
        Session session = getSession();
        List<Employee> list = session.createCriteria(Employee.class)
                .addOrder(Order.desc("salary"))
                .setFirstResult(0).setMaxResults(5).list();
        session.close();
        return list;
    }

    public Employee getHighestSalaryEmployee() {
        Session session = getSession();
        Employee employee = (Employee) session.createCriteria(Employee.class)
                .addOrder(Order.desc("salary"))
                .addOrder(Order.asc("id"))
                .setMaxResults(1).uniqueResult();
        session.close();
        return employee;
    }

    public Employee getLowestSalaryEmployee() {
        Session session = getSession();
        Employee employee = (Employee) session.createCriteria(Employee.class)
                .addOrder(Order.asc("salary"))
                .addOrder(Order.asc("id"))
                .setMaxResults(1).uniqueResult();
        session.close();
        return employee;
    }

    public Employee getSecondHighestSalaryEmployee() {
        Session session = getSession();
        Double maxSalary = (Double) session.createCriteria(Employee.class)
                .setProjection(Projections.max("salary")).uniqueResult();

        Employee employee = null;

        if (maxSalary != null) {
            employee = (Employee) session.createCriteria(Employee.class)
                    .add(Restrictions.lt("salary", maxSalary))
                    .addOrder(Order.desc("salary"))
                    .addOrder(Order.asc("id"))
                    .setMaxResults(1).uniqueResult();
        }

        session.close();
        return employee;
    }

    public Employee getSecondLowestSalaryEmployee() {
        Session session = getSession();
        Double minSalary = (Double) session.createCriteria(Employee.class)
                .setProjection(Projections.min("salary")).uniqueResult();

        Employee employee = null;

        if (minSalary != null) {
            employee = (Employee) session.createCriteria(Employee.class)
                    .add(Restrictions.gt("salary", minSalary))
                    .addOrder(Order.asc("salary"))
                    .addOrder(Order.asc("id"))
                    .setMaxResults(1).uniqueResult();
        }

        session.close();
        return employee;
    }
}
package com.cognizant.dao;

import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void signUp(Employee employee) {

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(employee);
        transaction.commit();
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag=false;
        for(Employee employee:getAllData())
        {
          if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword))
          {
             flag=true;
          }
        }
        return flag;
    }

    @Override
    public void saveBulkOfData(List<Employee> employees) {

        Session session=factory.openSession();

        for (Employee employee:employees){
            Transaction transaction=session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getDataById(int empId) {
        Session session=factory.openSession();
        Employee employee=(Employee) session.get(Employee.class,empId);
        return employee;
    }

    @Override
    public List<Employee> getDataByAnyInput(String input) {
        List<Employee> employeeList=new ArrayList<>();
        for(Employee employee:getAllData())
        {
            if(employee.getEmpName().equals(input)
            || String.valueOf(employee.getEmpId()).equals(input)
            || String.valueOf(employee.getEmpAge()).equals(input)
            || String.valueOf(employee.getEmpDOB()).equals(input)
            || employee.getEmpAddress().equals(input)
            || String.valueOf(employee.getEmpEmailId()).equals(input)
            || String.valueOf(employee.getEmpPassword()).equals(input)
            || String.valueOf(employee.getEmpContactNumber()).equals(input)
            || String.valueOf(employee.getEmpSalary()).equals(input))
            employeeList.add(employee);

        }

        return employeeList;
    }

    @Override
    public List<Employee> getAllData() {
        Session session=factory.openSession();
        List<Employee> employees=session.createQuery("from Employee").list();
        return employees;
    }

    @Override
    public void updateDataById(int empId, Employee employee) {
        Session session=factory.openSession();
        Transaction transaction= session.beginTransaction();

        Employee employee1=getDataById(empId);
        //Employee employee1=(Employee) session.get(Employee.class,empId);

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpAge(employee.getEmpAge());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());

        session.update(employee1);
        transaction.commit();

    }

    @Override
    public void deleteDataById(int empId) {
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();
        Employee employee=(Employee) session.get(Employee.class,empId);
        session.delete(employee);
        transaction.commit();
    }

    @Override
    public void deleteAllData() {

        Session session= factory.openSession();
        for (Employee employee:getAllData()){
            Transaction transaction=session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }


//        Session session= factory.openSession();
//        List<Employee> employees = session.createQuery("from Employee").list();
//        for(Employee employee:employees) {
//            Transaction transaction = session.beginTransaction();
//            session.delete(employee);
//            transaction.commit();
//        }

    }
}

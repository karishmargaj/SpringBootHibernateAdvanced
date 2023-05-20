package com.cognizant.service;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDaoImpl;

    @Override
    public void signUp(Employee employee) {
        employeeDaoImpl.signUp(employee);
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDaoImpl.signIn(empEmailId,empPassword);
    }

    @Override
    public void saveBulkOfData(List<Employee> employees) {
         employeeDaoImpl.saveBulkOfData(employees);
    }

    @Override
    public Employee getDataById(int empId) {
        return employeeDaoImpl.getDataById(empId);
    }

    @Override
    public List<Employee> getDataByAnyInput(String input) {
        return employeeDaoImpl.getDataByAnyInput(input);
    }

    @Override
    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    @Override
    public void updateDataById(int empId, Employee employee) {
         employeeDaoImpl.updateDataById(empId,employee);
    }

    @Override
    public void deleteDataById(int empId) {
        employeeDaoImpl.deleteDataById(empId);
    }

    @Override
    public void deleteAllData() {
        employeeDaoImpl.deleteAllData();
    }
}

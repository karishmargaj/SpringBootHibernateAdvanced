package com.cognizant.service;

import com.cognizant.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void signUp(Employee employee);

    public boolean signIn(String empEmailId, String empPassword);

    public void saveBulkOfData(List<Employee> employees);

    public Employee getDataById(int empId);

    public List<Employee> getDataByAnyInput(String input);

    public List<Employee> getAllData();

    public void updateDataById(int empId, Employee employee);

    public void deleteDataById(int empId);

    public void deleteAllData();
}

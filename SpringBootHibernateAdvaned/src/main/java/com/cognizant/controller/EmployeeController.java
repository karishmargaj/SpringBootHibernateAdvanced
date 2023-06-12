package com.cognizant.controller;

import ch.qos.logback.core.model.conditional.ElseModel;
import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee)
     {
         employeeServiceImpl.signUp(employee);
        return ResponseEntity.ok("Signup Done successfully");
     }

     @GetMapping("/login/{empEmailId}/{empPassword}")
     public ResponseEntity<Boolean> login(@PathVariable String empEmailId, @PathVariable String empPassword)
     {
         return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
     }

     @PostMapping("/savebulkofdata")
     public ResponseEntity<String> saveBulkOfData(@RequestBody List<Employee> employees)
     {
         employeeServiceImpl.saveBulkOfData(employees);
         return ResponseEntity.ok("Data save successfully");
     }

     @GetMapping("/getdatabyid/{empId}")
     public ResponseEntity<Employee> getDataById(@PathVariable int empId)
     {
         return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
     }

     @GetMapping("/getalldata")
     public ResponseEntity<List<Employee>> getAllData()
     {
         return ResponseEntity.ok(employeeServiceImpl.getAllData());
     }

     @GetMapping("/getdatabyanyinput/{input}")
     public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable String input)
     {
         return ResponseEntity.ok(employeeServiceImpl.getDataByAnyInput(input));
     }

     @GetMapping("/getdatabyname/{empName}")
     public ResponseEntity <List<Employee>> getDataByName(@PathVariable String empName)
     {
         //return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(emp-> emp.getEmpName().equals(empName)).collect(Collectors.toList()));
         return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(cc->cc.getEmpName().equals(empName)).collect(Collectors.toList()));
     }

     @GetMapping("/getdatabycontactnumber/{empContactNumber}")
     public ResponseEntity<List<Employee>> getDataByContactNumber(@PathVariable long empContactNumber)
     {
         return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(cc->cc.getEmpContactNumber()==empContactNumber).collect(Collectors.toList()));
     }

     @GetMapping("/getdatabyemailid/{empEmailId}")
     public ResponseEntity<List<Employee>> getDataByEmailId(@PathVariable String empEmailId)
     {
         return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(cc->cc.getEmpEmailId().equals(empEmailId)).collect(Collectors.toList()));
     }

     @GetMapping("/sortbyname")
     public ResponseEntity<List<Employee>> sortByName()
     {
         return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList()));
     }

     @GetMapping("/sortbyid")
     public ResponseEntity<List<Employee>> sortById()
     {
         return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparingLong(Employee::getEmpId)).collect(Collectors.toList()));
     }

     @GetMapping("/sortbysalary")
     public ResponseEntity<List<Employee>> sortBySalary()
     {
         return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList()));
     }

    @GetMapping("/filterdatabysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterDataBySalary(@PathVariable double empSalary){
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(emp-> emp.getEmpSalary()>=empSalary).collect(Collectors.toList()));

    }


     @PutMapping("/updatedatabyid/{empId}")
     public ResponseEntity<String> updateDataById(@RequestBody Employee employee,@PathVariable int empId)
     {
         employeeServiceImpl.updateDataById(empId,employee);
         return ResponseEntity.ok("Data Updated successfully");
     }

     @DeleteMapping("/deletedatabyid/{empId}")
     public ResponseEntity<String> deleteDataById(@PathVariable int empId)
     {
         employeeServiceImpl.deleteDataById(empId);
         return ResponseEntity.ok("Data deleted successfully");
     }

     @DeleteMapping("/deletealldata")
     public ResponseEntity<String> deleteAllData()
     {
         employeeServiceImpl.deleteAllData();
         return ResponseEntity.ok("All data deleted successfully");
     }

//dcrftgyhujigyhujh




}

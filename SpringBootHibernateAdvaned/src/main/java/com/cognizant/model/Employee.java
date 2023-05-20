package com.cognizant.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private int empId;

    private String empName;

    private String empAddress;

    private  int empAge;

    private double empSalary;

    @JsonFormat(pattern = "dd-MM-yyyy",timezone ="Asia/Kolkata")
    private Date empDOB;

    @Column(unique = true)
    private long empContactNumber;

    @Column(unique = true)
    private String empEmailId;

    @Column(unique = true)
    private String empPassword;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notix.controller;

import com.notix.model.Employee;
import com.notix.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jibin
 */
@RestController
public class EmpServiceController {
    
    @Autowired
    private EmployeeRepository repo;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("v1/employees/{empId}")
    public Employee retrieveEmployeeId(@PathVariable("empId") String empid) {
        Employee value=repo.findById(empid);
         logger.info("{}",value);
         return value;
    }
}

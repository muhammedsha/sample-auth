/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notix.controller;

import com.notix.model.Employee;
import com.notix.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jibin
 */
@RestController
@RequestMapping(value="v1/employees/{empId}/login")
public class LoginServiceController {
    @Autowired
    private EmployeeService employeeService;

    //@Autowired
    //private ServiceConfig serviceConfig;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public Employee getEmployees( @PathVariable("empId") String empId) {

        return employeeService.getEmployeeById(empId);
       // return employeeService.retrieveEmpInfo(empId);
    }
    
    
}

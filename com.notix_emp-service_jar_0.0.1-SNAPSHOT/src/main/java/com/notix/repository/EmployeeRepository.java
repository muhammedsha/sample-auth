/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notix.repository;

import com.notix.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jibin
 */
public interface EmployeeRepository extends JpaRepository<Employee, String>{
    
    Employee findById(String empid);
    
}

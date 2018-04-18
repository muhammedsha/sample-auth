/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notix.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.notix.clients.EmployeeRestTemplateClient;
import com.notix.model.Employee;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jibin
 */
@Service
public class EmployeeService {
    
   // @Autowired
   // private EmployeeRepository employeeRepository;

    
    @Autowired
    EmployeeRestTemplateClient employeeRestClient;
    Employee employee;
    
    //******* currently not used anywhere
            public Employee retrieveEmpInfo(String empId){
        
                    employee = employeeRestClient.getEmployee(empId);
        
                    return employee;
                }
    //******
            //For hystrix timout
            private void randomlyRunLong(){
      Random rand = new Random();

      int randomNum = rand.nextInt((3 - 1) + 1) + 1;

      if (randomNum==3) sleep();
    }

    private void sleep(){
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
        }
    }
    //Hystrix thread pool
    @HystrixCommand(fallbackMethod = "buildFallbackEmployee",
            threadPoolKey = "employeeByIdThreadPool",
            threadPoolProperties =
                    {@HystrixProperty(name = "coreSize",value="30"),
                     @HystrixProperty(name="maxQueueSize", value="10")},
            commandProperties={
                     @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),
                     @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="75"),
                     @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),
                     @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="15000"),
                     @HystrixProperty(name="metrics.rollingStats.numBuckets", value="5")}
    )
    public Employee getEmployeeById(String empId){
        randomlyRunLong();
        return employeeRestClient.getEmployee(empId);
    }
    
    // Fallback Method
    private Employee buildFallbackEmployee(String empId){
       // List<License> fallbackList = new ArrayList<>();
        Employee emp = new Employee()
                .withId(empId)
                .withName( "Fallback Method" )
                .withEmail("Not Available")
                .withContact("Not Available");

        //fallbackList.add(license);
        return emp;
    }
    
}

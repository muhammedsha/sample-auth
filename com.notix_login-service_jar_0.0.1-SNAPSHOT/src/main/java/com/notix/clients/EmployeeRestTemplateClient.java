/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notix.clients;

import com.notix.model.Employee;
//import com.notix.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jibin
 */
@Component
public class EmployeeRestTemplateClient {
    @Autowired
    RestTemplate restTemplate;
    //OAuth2RestTemplate restTemplate;

    //private static final Logger logger = LoggerFactory.getLogger(EmployeeRestTemplateClient.class);
    public Employee getEmployee(String empId){
        //logger.debug("In Login Service.getEmployee: {}", UserContext.getCorrelationId());
        ResponseEntity<Employee> restExchange =
                restTemplate.exchange(
                        "http://empservice/v1/employees/{empId}",
                        HttpMethod.GET,
                        null, Employee.class, empId);

        return restExchange.getBody();
    }
    
}

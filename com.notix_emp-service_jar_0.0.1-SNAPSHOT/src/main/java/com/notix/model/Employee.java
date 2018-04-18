/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jibin
 */
@Entity
public class Employee {
    @Id
    private String id;
    @Column(name="emp_name")
    private String name;
    @Column(name="email_id")
    private String email;
    @Column(name="contact_no")
    private String contact;

    public Employee() {
    }

    public Employee(String id, String name, String email, String contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
    
}

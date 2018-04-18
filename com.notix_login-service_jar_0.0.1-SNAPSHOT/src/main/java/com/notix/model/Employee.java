/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notix.model;

/**
 *
 * @author jibin
 */
public class Employee {
    
    String id;
    String name;
    String email;
    String contact;

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

    
    
    public Employee withId(String empId){
    this.setId(empId);
    return this;
  }

  public Employee withName(String name){
    this.setName(name);
    return this;
  }

  public Employee withEmail(String email){
    this.setEmail(email);
    return this;
  }

  public Employee withContact(String contact){
    this.setContact(contact);
    return this;
  }

    
}

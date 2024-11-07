package com.edu.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RegisteredServices")
public class RegisteredServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registeredServiceID;

    @ManyToOne
    @JoinColumn(name = "serviceID", nullable = false)
    private Services service;

    @ManyToOne
    @JoinColumn(name = "employeeID", nullable = false)
    private Employee employee;

    private Date registrationDate;
    private String status;
    private String notes;

    // Getters and Setters
    public Integer getRegisteredServiceID() {
        return registeredServiceID;
    }

    public void setRegisteredServiceID(Integer registeredServiceID) {
        this.registeredServiceID = registeredServiceID;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}


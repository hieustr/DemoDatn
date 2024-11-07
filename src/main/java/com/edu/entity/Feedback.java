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
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackID;

    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "orderID", nullable = false)
    private Orders order;

    private Integer rating;
    private String comments;
    private Date feedbackDate;
    private String isResolved;

    // Getters and Setters
    public Integer getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(Integer feedbackID) {
        this.feedbackID = feedbackID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getIsResolved() {
        return isResolved;
    }

    public void setIsResolved(String isResolved) {
        this.isResolved = isResolved;
    }
}


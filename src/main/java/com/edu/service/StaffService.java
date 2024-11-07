package com.edu.service;

import java.util.List;

import com.edu.entity.Staff;

public interface StaffService {
    List<Staff> getAllStaff();
    Staff getStaffById(int id);
    Staff saveStaff(Staff staff);
    void deleteStaff(int id);
}

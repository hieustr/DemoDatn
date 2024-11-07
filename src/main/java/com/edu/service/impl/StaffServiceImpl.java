package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Staff;
import com.edu.repository.StaffRepository;
import com.edu.service.StaffService;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffById(int id) {
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(int id) {
        staffRepository.deleteById(id);
    }
}

package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edu.entity.Staff;
import com.edu.service.StaffService;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable int id) {
        Staff staff = staffService.getStaffById(id);
        if (staff != null) {
            return ResponseEntity.ok(staff);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Staff createStaff(@RequestBody Staff staff) {
        return staffService.saveStaff(staff);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable int id, @RequestBody Staff staffDetails) {
        Staff staff = staffService.getStaffById(id);
        if (staff != null) {
            staff.setName(staffDetails.getName());
            staff.setPosition(staffDetails.getPosition());
            staff.setIsActive(staffDetails.getIsActive());
            return ResponseEntity.ok(staffService.saveStaff(staff));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable int id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}


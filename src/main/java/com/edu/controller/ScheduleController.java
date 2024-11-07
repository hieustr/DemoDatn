package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edu.entity.Schedule;
import com.edu.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable int id) {
        Schedule schedule = scheduleService.getScheduleById(id);
        if (schedule != null) {
            return ResponseEntity.ok(schedule);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable int id, @RequestBody Schedule scheduleDetails) {
        Schedule schedule = scheduleService.getScheduleById(id);
        if (schedule != null) {
            schedule.setStartTime(scheduleDetails.getStartTime());
            schedule.setEndTime(scheduleDetails.getEndTime());
            schedule.setLocation(scheduleDetails.getLocation());
            schedule.setIsActive(scheduleDetails.getIsActive());
            return ResponseEntity.ok(scheduleService.saveSchedule(schedule));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable int id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}


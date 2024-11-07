package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Schedule;
import com.edu.repository.ScheduleRepository;
import com.edu.service.ScheduleService;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleById(int id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(int id) {
        scheduleRepository.deleteById(id);
    }
}

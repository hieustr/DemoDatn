package com.edu.service;

import java.util.List;

import com.edu.entity.Schedule;

public interface ScheduleService {
    List<Schedule> getAllSchedules();
    Schedule getScheduleById(int id);
    Schedule saveSchedule(Schedule schedule);
    void deleteSchedule(int id);
}

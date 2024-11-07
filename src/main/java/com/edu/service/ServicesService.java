package com.edu.service;

import java.util.List;

import com.edu.entity.Services;

public interface ServicesService {
    List<Services> getAllServices();
    Services getServiceById(int id);
    Services saveService(Services service);
    void deleteService(int id);
}

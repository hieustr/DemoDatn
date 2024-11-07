package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Services;
import com.edu.repository.ServiceRepository;
import com.edu.service.ServicesService;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServicesServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Services> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Services getServiceById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Services saveService(Services services) {
        return serviceRepository.save(services);
    }

    @Override
    public void deleteService(int id) {
        serviceRepository.deleteById(id);
    }
}
package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Profile;
import com.edu.repository.ProfileRepository;
import com.edu.service.ProfileService;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileById(int id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(int id) {
        profileRepository.deleteById(id);
    }
}

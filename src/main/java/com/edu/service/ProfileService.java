package com.edu.service;

import java.util.List;

import com.edu.entity.Profile;

public interface ProfileService {
    List<Profile> getAllProfiles();
    Profile getProfileById(int id);
    Profile saveProfile(Profile profile);
    void deleteProfile(int id);
}

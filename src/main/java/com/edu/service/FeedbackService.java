package com.edu.service;

import java.util.List;

import com.edu.entity.Feedback;

public interface FeedbackService {
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(int id);
    Feedback saveFeedback(Feedback feedback);
    void deleteFeedback(int id);
}

package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Feedback;
import com.edu.repository.FeedbackRepository;
import com.edu.service.FeedbackService;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback getFeedbackById(int id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(int id) {
        feedbackRepository.deleteById(id);
    }
}

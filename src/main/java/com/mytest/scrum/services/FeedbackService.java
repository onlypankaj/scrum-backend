package com.mytest.scrum.services;

import com.mytest.scrum.dto.FeedbackCreateRequest;
import com.mytest.scrum.model.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    Feedback saveFeedback(FeedbackCreateRequest feedbackCreateRequest);
    List<Feedback> getAllFeedbacks();

    List<Feedback> getFeedbacksForRetroId(Long id);
}

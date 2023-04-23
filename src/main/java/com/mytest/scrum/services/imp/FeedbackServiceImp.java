package com.mytest.scrum.services.imp;

import com.mytest.scrum.dto.FeedbackCreateRequest;
import com.mytest.scrum.model.Feedback;
import com.mytest.scrum.model.Participant;
import com.mytest.scrum.model.Retrospective;
import com.mytest.scrum.repository.FeedbackRepository;
import com.mytest.scrum.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImp implements FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback saveFeedback(FeedbackCreateRequest feedbackCreateRequest) {
        Participant participant = new Participant();
        participant.setPartId(feedbackCreateRequest.getPartId());

        Retrospective retrospective = new Retrospective();
        retrospective.setRetroId(feedbackCreateRequest.getRetroId());

        Feedback feedback = new Feedback();
        feedback.setBody(feedbackCreateRequest.getBody());
        feedback.setType(feedbackCreateRequest.getType());
        feedback.setParticipant(participant);
        feedback.setRetrospective(retrospective);

        return saveFeedback(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public List<Feedback> getFeedbacksForRetroId(Long id) {
        return feedbackRepository.findByRetroId(id);
    }
}

package com.mytest.scrum.controller;

import com.mytest.scrum.dto.FeedbackCreateRequest;
import com.mytest.scrum.model.Feedback;
import com.mytest.scrum.services.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping("")
    public List<Feedback> getAllFeedbacks(){
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("/{id}")
    public List<Feedback> getFeedbacksForRetroId(@PathVariable Long id){
        return feedbackService.getFeedbacksForRetroId(id);
    }

    @PostMapping("/add")
    public Feedback addFeedback(@Valid @RequestBody FeedbackCreateRequest feedbackCreateRequest){
        return feedbackService.saveFeedback(feedbackCreateRequest);
    }
}

package com.mytest.scrum.controller;

import com.mytest.scrum.model.Participant;
import com.mytest.scrum.services.ParticipantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/participant")
@CrossOrigin(origins = "http://localhost:3000")
public class ParticipantController {

    @Autowired
    ParticipantService participantService;

    @GetMapping(value = "")
    public List<Participant> getAllParticipants(){
        return participantService.getAllParticipants();
    }
}

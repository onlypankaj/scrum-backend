package com.mytest.scrum.services.imp;

import com.mytest.scrum.model.Participant;
import com.mytest.scrum.repository.ParticipantRepository;
import com.mytest.scrum.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImp implements ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    @Override
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }
}

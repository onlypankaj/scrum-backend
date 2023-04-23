package com.mytest.scrum.services.imp;

import com.mytest.scrum.dto.RetrospectiveCreateRequest;
import com.mytest.scrum.model.Participant;
import com.mytest.scrum.model.Retrospective;
import com.mytest.scrum.repository.ParticipantRepository;
import com.mytest.scrum.repository.RetrospectiveRepository;
import com.mytest.scrum.services.RetrospectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class RetrospectiveServiceImp implements RetrospectiveService {

    @Autowired
    private RetrospectiveRepository retrospectiveRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public Optional<Retrospective> getRetrospectiveById(Long Id) {
        return retrospectiveRepository.findById(Id);
    }

    @Override
    public Retrospective saveRetrospective(Retrospective retrospective) {
        return retrospectiveRepository.save(retrospective);
    }

    @Override
    public Retrospective saveRetrospective(RetrospectiveCreateRequest retrospectiveCreateRequest) {

        Retrospective retrospective = new Retrospective();
        retrospective.setName(retrospectiveCreateRequest.getName());
        retrospective.setSummary(retrospectiveCreateRequest.getSummary());
        retrospective.setCreateDate(retrospectiveCreateRequest.getCreateDate());

        List<Participant> partProxies = new ArrayList<>();
        for(Long partId : retrospectiveCreateRequest.getParticipants()){
            Optional<Participant> tempParticipant = participantRepository.findById(partId);
            partProxies.add(tempParticipant.get());
        }

        retrospective.setParticipants(new HashSet<>(partProxies));

        return saveRetrospective(retrospective);
    }

    @Override
    public List<Retrospective> getAllRetrospectives() {
        return retrospectiveRepository.findAll();
    }

    @Override
    public List<Retrospective> getAllByDate(LocalDate creationDate) {
        return retrospectiveRepository.getAllByDate(creationDate);
    }
}

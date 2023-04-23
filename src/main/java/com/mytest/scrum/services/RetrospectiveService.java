package com.mytest.scrum.services;

import com.mytest.scrum.dto.RetrospectiveCreateRequest;
import com.mytest.scrum.model.Retrospective;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RetrospectiveService {

    Optional<Retrospective> getRetrospectiveById(Long id);
    Retrospective saveRetrospective(Retrospective retrospective);
    Retrospective saveRetrospective(RetrospectiveCreateRequest retrospectiveCreateRequest);
    List<Retrospective> getAllRetrospectives();
    List<Retrospective> getAllByDate(LocalDate creationDate);
}

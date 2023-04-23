package com.mytest.scrum.controller;

import com.mytest.scrum.dto.RetrospectiveCreateRequest;
import com.mytest.scrum.exception.RetrospectiveNotFoundException;
import com.mytest.scrum.model.Retrospective;
import com.mytest.scrum.services.RetrospectiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/retrospective")
@CrossOrigin(origins = "http://localhost:3000")
public class RetrospectiveController {

    @Autowired
    RetrospectiveService retrospectiveService;

//    @GetMapping(value="", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @GetMapping(value = "")
    public List<Retrospective> getAllRetrospectives(){
        return retrospectiveService.getAllRetrospectives();
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Retrospective addRetrospective(@Valid @RequestBody RetrospectiveCreateRequest request){
        return retrospectiveService.saveRetrospective(request);
    }

    @GetMapping("/searchbyid/{id}")
    public Retrospective getRetrospectiveById(@PathVariable Long id){
        return retrospectiveService.getRetrospectiveById(id).orElseThrow(() -> new RetrospectiveNotFoundException());
    }

    @GetMapping("/{creationDate}")
    public List<Retrospective> getAllRetrospectiveByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate creationDate){
        return retrospectiveService.getAllByDate(creationDate);
    }
}

package com.mytest.scrum.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mytest.scrum.dto.RetrospectiveCreateRequest;
import com.mytest.scrum.model.Participant;
import com.mytest.scrum.model.Retrospective;
import com.mytest.scrum.services.RetrospectiveService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.*;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class RetrospectiveControllerTest {

    @Mock
    private RetrospectiveService retrospectiveService;

    @InjectMocks
    private RetrospectiveController retrospectiveController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(retrospectiveController).build();
    }

    @Test
    public void testAddRetrospective() throws Exception {
        // Define request body
        RetrospectiveCreateRequest retrospectiveCreateRequest = new RetrospectiveCreateRequest();
        retrospectiveCreateRequest.setName("Test Retrospective Name");
        retrospectiveCreateRequest.setSummary("Test Retrospective Summary");
        LocalDate date = LocalDate.of(2020,1,8);
        retrospectiveCreateRequest.setCreateDate(date);
        retrospectiveCreateRequest.setParticipants(Arrays.asList(101l,102l));

        // Define response
        Retrospective expectedRetrospective = new Retrospective();
        expectedRetrospective.setRetroId(1l);
        expectedRetrospective.setName("Test Retrospective Name");
        expectedRetrospective.setSummary("Test Retrospective Summary");
        expectedRetrospective.setCreateDate(LocalDate.of(2020,1,8));

        Participant participant1 = new Participant();
        participant1.setPartId(999l);
        participant1.setName("xyz");

        Participant participant2 = new Participant();
        participant2.setPartId(999l);
        participant2.setName("xyz");

        Set<Participant> participants = new HashSet<>();
        participants.add(participant1);
        participants.add(participant2);
        expectedRetrospective.setParticipants(participants);


        // Mock repo service save
//        when(retrospectiveService.saveRetrospective(retrospectiveCreateRequest)).thenReturn(expectedRetrospective);

        mockMvc.perform(MockMvcRequestBuilders.post("/retrospective")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(retrospectiveCreateRequest)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetAllRetrospectives() throws Exception {
        // Arrange
        List<Retrospective> retrospectives = new ArrayList<>();

        Retrospective retrospective1 = new Retrospective();
        retrospective1.setRetroId(1l);
        retrospective1.setName("Test1 Retrospective Name");
        retrospective1.setSummary("Test1 Retrospective Summary");
        retrospective1.setCreateDate(LocalDate.of(2020,1,8));

        Retrospective retrospective2 = new Retrospective();
        retrospective1.setRetroId(2l);
        retrospective1.setName("Test2 Retrospective Name");
        retrospective1.setSummary("Test2 Retrospective Summary");
        retrospective1.setCreateDate(LocalDate.of(2020,2,8));

        retrospectives.add(retrospective1);
        retrospectives.add(retrospective2);

        Mockito.when(retrospectiveService.getAllRetrospectives()).thenReturn(retrospectives);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/retrospective")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

package com.mytest.scrum.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedId;
    private String body;
    @Enumerated(EnumType.STRING)
    private FeedbackType type;
    @ManyToOne(targetEntity = Retrospective.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "retro_id")
    private Retrospective retrospective;
    @ManyToOne(targetEntity = Participant.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "part_id")
    private Participant participant;
}

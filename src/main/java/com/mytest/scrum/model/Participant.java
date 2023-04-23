package com.mytest.scrum.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long partId;
    private String name;

    @ManyToMany(mappedBy = "participants")
    @JsonBackReference
    private Set<Retrospective> retrospectives = new HashSet<>();
}

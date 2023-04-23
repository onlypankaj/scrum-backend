package com.mytest.scrum.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Retrospective {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long retroId;
    @Column(unique = true, nullable=false)
    private String name;
    private String summary;
    @Column(nullable = false)
    private LocalDate createDate;

    @ManyToMany
    @JoinTable(name="retrospective_part",
            joinColumns = {@JoinColumn(name = "retro_id", nullable = false)},
            inverseJoinColumns = { @JoinColumn(name = "part_id", nullable = false)})
    @JsonManagedReference
    private Set<Participant> participants = new HashSet<>();

}

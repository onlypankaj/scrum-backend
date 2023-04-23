package com.mytest.scrum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RetrospectiveCreateRequest {
    private String name;
    private String summary;
    @NotNull
    private LocalDate createDate;
    @NotNull
    List<Long> participants;
}

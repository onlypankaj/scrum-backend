package com.mytest.scrum.dto;

import com.mytest.scrum.model.FeedbackType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackCreateRequest {
    @NotNull
    private String body;
    @NotNull
    @Enumerated(EnumType.STRING)
    private FeedbackType type;
    @NotNull
    private Long partId;
    @NotNull
    private Long retroId;
}

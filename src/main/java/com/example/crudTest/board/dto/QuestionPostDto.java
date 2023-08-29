package com.example.crudTest.board.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class QuestionPostDto {
    @NotNull
    private long memberId;

    @NotNull
    private String title;

    @NotNull
    private String body;
}

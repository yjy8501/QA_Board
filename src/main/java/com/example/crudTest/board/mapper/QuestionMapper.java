package com.example.crudTest.board.mapper;

import com.example.crudTest.board.dto.QuestionPostDto;
import com.example.crudTest.board.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);
}

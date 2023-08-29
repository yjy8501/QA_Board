package com.example.crudTest.board.controller;

import com.example.crudTest.board.dto.QuestionPostDto;
import com.example.crudTest.board.entity.Question;
import com.example.crudTest.board.mapper.QuestionMapper;
import com.example.crudTest.board.repository.QuestionRepository;
import com.example.crudTest.board.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionMapper questionMapper;
    private final QuestionService questionService;

    public QuestionController(QuestionMapper questionMapper, QuestionService questionService) {
        this.questionMapper = questionMapper;
        this.questionService = questionService;
    }

    @PostMapping("/{memberId}")
    public ResponseEntity createQuestion(@Validated @RequestBody QuestionPostDto questionPostDto,
                                         @Positive @PathVariable("memberId") int memberId) {
        questionPostDto.setMemberId(memberId);
        Question question = questionMapper.questionPostDtoToQuestion(questionPostDto);

        return new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.CREATED);
    }
}

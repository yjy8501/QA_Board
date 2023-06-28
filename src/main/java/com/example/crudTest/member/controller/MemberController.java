package com.example.crudTest.member.controller;

import com.example.crudTest.member.dto.MemberPostDto;
import com.example.crudTest.member.dto.MemberResponse;
import com.example.crudTest.member.entity.Member;
import com.example.crudTest.member.mapper.MemberMapper;
import com.example.crudTest.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@Validated
public class MemberController {

    final private MemberMapper memberMapper;
    final private MemberService memberService;

    public MemberController(MemberMapper memberMapper, MemberService memberService) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        Member member = memberMapper.memberPostDtoToMember(memberPostDto);
        MemberResponse memberResponse = memberMapper.memberToMemberResponse(memberService.createMember(member));

        return new ResponseEntity(memberResponse, HttpStatus.CREATED);
    }
}

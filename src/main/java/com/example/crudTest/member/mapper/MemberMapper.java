package com.example.crudTest.member.mapper;

import com.example.crudTest.member.dto.MemberPostDto;
import com.example.crudTest.member.dto.MemberResponse;
import com.example.crudTest.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper{
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    MemberResponse memberToMemberResponse(Member member);
}

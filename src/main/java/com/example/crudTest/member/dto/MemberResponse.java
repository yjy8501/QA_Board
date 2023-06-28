package com.example.crudTest.member.dto;

import com.example.crudTest.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse {
    private long memberId;

    private String email;

    private String name;

    private Member.MemberRole role;

}

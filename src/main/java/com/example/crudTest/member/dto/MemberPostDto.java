package com.example.crudTest.member.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberPostDto {
    @Email
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String name;

}

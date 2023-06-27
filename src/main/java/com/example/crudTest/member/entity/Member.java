package com.example.crudTest.member.entity;

import com.example.crudTest.board.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;


    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column
    private MemberRole role = MemberRole.USER_ROLE;

    @OneToMany(mappedBy = "member")
    private List<Question> question;


    public enum MemberRole {
        ADMIN_ROLE("1"),
        USER_ROLE("0");

        @Getter
        private String role;

        MemberRole(String role) {
            this.role = role;
        }
    }
}

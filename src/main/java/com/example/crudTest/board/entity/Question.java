package com.example.crudTest.board.entity;

import com.example.crudTest.audit.Auditable;
import com.example.crudTest.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Question extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    @Enumerated
    @Column
    private QuestionState questionState = QuestionState.QUESTION_REGISTERED;

    @Enumerated
    @Column
    private QuestionScope questionScope = QuestionScope.PUBLIC;



    public enum QuestionState {
        QUESTION_REGISTERED("질문 등록 상태"),
        QUESTION_ANSWERED("답변 완료 상태"),
        QUESTION_DELETED("질문 삭제 상태"),
        QUESTION_DEACTIVED("질문 비활성화 상태");

        @Getter
        private String state;

        QuestionState(String state) {
            this.state = state;
        }
    }

    public enum QuestionScope {
        PUBLIC("공개글 상태"),
        SECRET("비밀글 상태");

        @Getter
        private String scope;

        QuestionScope(String scope) {
            this.scope = scope;
        }
    }


}

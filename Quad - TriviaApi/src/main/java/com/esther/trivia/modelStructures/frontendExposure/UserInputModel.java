package com.esther.trivia.modelStructures.frontendExposure;

public class UserInputModel {
    private String question;
    private String submitted_answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSubmitted_answer() {
        return submitted_answer;
    }

    public void setSubmitted_answer(String submitted_answer) {
        this.submitted_answer = submitted_answer;
    }
}

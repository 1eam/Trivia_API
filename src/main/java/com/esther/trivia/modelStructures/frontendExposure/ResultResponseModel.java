package com.esther.trivia.modelStructures.frontendExposure;

public class ResultResponseModel {
    private String correct_answer;
    private boolean isAnswered_correct = false;

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public boolean isAnswered_correct() {
        return isAnswered_correct;
    }

    public void setAnswered_correct(boolean answered_correct) {
        isAnswered_correct = answered_correct;
    }
}

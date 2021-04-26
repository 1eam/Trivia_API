
package com.esther.trivia.modelStructures.backend.triviaAPIResponseModel;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class Result {

    private String category;
    private String type;
    private String difficulty;
    private String question;
    private String correct_answer;
    private List<String> incorrect_answers;

    public Result() {
    }

    public Result(Result result) {

        Result result2 = result;
        result = new Result();

        this.category = result2.getCategory();
        this.type = result2.getType();
        this.difficulty = result2.getDifficulty();
        this.question = result2.getQuestion();
        this.correct_answer = result2.getCorrect_answer();
        this.incorrect_answers = result2.getIncorrect_answers();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public List<String> getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(List<String> incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }
}

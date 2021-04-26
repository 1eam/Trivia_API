package com.esther.trivia.controller;

import com.esther.trivia.modelStructures.backend.triviaAPIResponseModel.TriviaResponseModel;
import com.esther.trivia.modelStructures.frontendExposure.ResultResponseModel;
import com.esther.trivia.modelStructures.frontendExposure.UserInputModel;
import com.esther.trivia.service.QuestionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private final QuestionsService questionsService;

    public Controller(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/questions")
    public ResponseEntity<TriviaResponseModel> getTrivias(){
        ResponseEntity<TriviaResponseModel> trivias = questionsService.getTrivias();

        return trivias;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/checkanswer")
    public ResponseEntity<ResultResponseModel> checkAnswer(@RequestBody UserInputModel userInput){

        ResponseEntity<ResultResponseModel> result = questionsService.checkAnswer(userInput);
        return result;
    }
}

package com.esther.trivia.service;

import com.esther.trivia.modelStructures.backend.triviaAPIResponseModel.TriviaResponseModel;
import com.esther.trivia.modelStructures.frontendExposure.ResultResponseModel;
import com.esther.trivia.modelStructures.frontendExposure.UserInputModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {

    ActionService actionService;

    public QuestionsService(ActionService actionService) {
        this.actionService = actionService;
    }

    public ResponseEntity<TriviaResponseModel> getTrivias(){
        TriviaResponseModel filteredTrivias = actionService.getFilteredTrivias();

        return ResponseEntity.status(HttpStatus.OK).body(filteredTrivias);
    }

    public ResponseEntity<ResultResponseModel> checkAnswer(UserInputModel userInput){
        final ResultResponseModel response = actionService.checkAnswer(userInput);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
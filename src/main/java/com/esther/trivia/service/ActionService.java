package com.esther.trivia.service;

import com.esther.trivia.dataSource.TriviaClient;
import com.esther.trivia.modelStructures.backend.triviaAPIResponseModel.Result;
import com.esther.trivia.modelStructures.backend.triviaAPIResponseModel.TriviaResponseModel;
import com.esther.trivia.modelStructures.frontendExposure.ResultResponseModel;
import com.esther.trivia.modelStructures.frontendExposure.UserInputModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ActionService {
    TriviaClient triviaClient;

    public ActionService(TriviaClient triviaClient) {
        this.triviaClient = triviaClient;
    }

    private TriviaResponseModel initialTrivias = new TriviaResponseModel();


    private TriviaResponseModel getTriviasFromAPI(){

        TriviaResponseModel triviasFromAPI = triviaClient.get5TriviasFromAPI();

        return triviasFromAPI;
    }

    private void storeInitialTrivias(TriviaResponseModel filteredTriviasFromAPI){

        List<Result> triviaResults = filteredTriviasFromAPI.getResults();

        Result initialQuestion1 = new Result(triviaResults.get(0));
        Result initialquestion2 = new Result(triviaResults.get(1));
        Result initialquestion3 = new Result(triviaResults.get(2));
        Result initialquestion4 = new Result(triviaResults.get(3));
        Result initialquestion5 = new Result(triviaResults.get(4));

        List<Result> initialTriviaResults = new ArrayList<>();
        initialTriviaResults.add(initialQuestion1);
        initialTriviaResults.add(initialquestion2);
        initialTriviaResults.add(initialquestion3);
        initialTriviaResults.add(initialquestion4);
        initialTriviaResults.add(initialquestion5);

        //Stores initial trivia's-structure in the "initialTrivias" variable
        initialTrivias.setResults(initialTriviaResults);
    }

    protected TriviaResponseModel getFilteredTrivias(){

        TriviaResponseModel filteredTriviasFromAPI = getTriviasFromAPI();

        //For later reference: to access correct answer
        storeInitialTrivias(filteredTriviasFromAPI);

        List<Result> triviaResults = filteredTriviasFromAPI.getResults();

        //Instance variables individual questions
        Result firstQuestion = triviaResults.get(0);
        Result secondQuestion = triviaResults.get(1);
        Result thirdQuestion = triviaResults.get(2);
        Result fourthQuestion = triviaResults.get(3);
        Result fifthQuestion = triviaResults.get(4);

        //Moves the correct answers to the incorrect answers
        firstQuestion.getIncorrect_answers().add(firstQuestion.getCorrect_answer());
        secondQuestion.getIncorrect_answers().add(secondQuestion.getCorrect_answer());
        thirdQuestion.getIncorrect_answers().add(thirdQuestion.getCorrect_answer());
        fourthQuestion.getIncorrect_answers().add(fourthQuestion.getCorrect_answer());
        fifthQuestion.getIncorrect_answers().add(fifthQuestion.getCorrect_answer());

        //Deletes the values inside the "correct_answer" properties.
        firstQuestion.setCorrect_answer(null);
        secondQuestion.setCorrect_answer(null);
        thirdQuestion.setCorrect_answer(null);
        fourthQuestion.setCorrect_answer(null);
        fifthQuestion.setCorrect_answer(null);

        //Randomizes order of answers
        Collections.shuffle(triviaResults.get(0).getIncorrect_answers());
        Collections.shuffle(triviaResults.get(1).getIncorrect_answers());
        Collections.shuffle(triviaResults.get(2).getIncorrect_answers());
        Collections.shuffle(triviaResults.get(3).getIncorrect_answers());
        Collections.shuffle(triviaResults.get(4).getIncorrect_answers());

        //Final API for client exposure
        filteredTriviasFromAPI.setResults(triviaResults);
        return filteredTriviasFromAPI;
    }

    public ResultResponseModel checkAnswer(UserInputModel userInput){

        //gets question
        String question = userInput.getQuestion();
        String submitted_answer = userInput.getSubmitted_answer();

        List<Result> originalTrivias = initialTrivias.getResults();
        ResultResponseModel response = new ResultResponseModel();


        //Loops through the originally exposed trivia-API (List<Result>) and finds targeted question.
        //Then gets the correct answer from this question
        for (int i = 0; i < originalTrivias.size(); i++){

            if (originalTrivias.get(i).getQuestion().contains(question)){
                String correct_answer = originalTrivias.get(i).getCorrect_answer();
                response.setCorrect_answer(correct_answer);

                //Checks if the users answer was correct & assign this to a boolean value for response.
                if (correct_answer.equals(submitted_answer)){
                    response.setAnswered_correct(true);
                }
            }
        }

        return response;
    }

}

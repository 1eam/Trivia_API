package com.esther.trivia.dataSource;

import com.esther.trivia.modelStructures.backend.triviaAPIResponseModel.TriviaResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "TriviaAPI", url = "https://opentdb.com/api.php?amount=5&difficulty=easy")
public interface TriviaClient {

    //Gets 5 trivia's from OpenTriviaDB: https://opentdb.com/api.php?amount=5&difficulty=easy
    @GetMapping()
    public TriviaResponseModel get5TriviasFromAPI();
}
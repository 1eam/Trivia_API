
package com.esther.trivia.modelStructures.backend.triviaAPIResponseModel;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.List;

@Generated("jsonschema2pojo")
public class TriviaResponseModel implements Serializable {
    private int responseCode;

    private List<Result> results;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
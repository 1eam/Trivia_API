
package com.esther.trivia.modelStructures.backend.dtoModels;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class TriviaResponseModelDTO {

    private int responseCode;

    private List<ResultDTO> resultDTO;


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<ResultDTO> getResultDTO() {
        return resultDTO;
    }

    public void setResultDTO(List<ResultDTO> resultDTO) {
        this.resultDTO = resultDTO;
    }
}
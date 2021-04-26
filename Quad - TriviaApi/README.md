# Trivia API
## _The Last Trivia API, Ever_

<img src="https://opentdb.com/images/logo.png" alt="drawing" width="200"/>


_TriviaAPI is a RESTApi that provides 5 trivia's from [OpenTriviaDB](https://opentdb.com/) client.
And in addition prevents the corrects answer from being exposed in the JSON response_

## Usage:

- **send request to /questions endpoint**
- **receive 5 trivias**
- **post submitted answer to /getanswer in the following JSON structure:**
```sh
{
    "question": "What year is it?",
    "submitted_answer": "2021"
}
```
- **receive back answer result & correct answer:**
 ```sh
{
    "correct_answer": "2021",
    "answered_correct": true
}
```
- **✨Magic ✨**

## Run
Standalone 

- git checkout 7b794dbffe62d4ac8f2273bb69c7d280f311ab6d
- Navigate to pom.xml
- Execute ```mvn spring-boot:run```

_*Note that the endpoints in this commithash are
http://localhost:8080/questions & http://localhost:8080/getanswer_

------------------------
_For the entire application to run including an API Gateway & a discovery service_
- _First run the [DescoveryService](https://github.com/1eam/Trivia_API/tree/master/Quad%20-%20Trivia%20DiscoveryService)_
- _Then the [API Gateway](https://github.com/1eam/Trivia_API/tree/master/Quad%20-%20Trivia%20API%20Gateway)_
- _And lastly This TriviaAPI server_



## About Application

**This API is part of [a bigger project](https://github.com/1eam/TriviaAPI_Frontend) which includes the frontend (which is still in development)
For frontend documentation visit https://github.com/1eam/TriviaAPI_Frontend**

## License

none

**Free Software :D**
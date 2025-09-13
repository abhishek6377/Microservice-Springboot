package com.example.demo.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Question;

@FeignClient(name = "question-service", url = "http://localhost:8082")
public interface QuestionFeignClient {
    @GetMapping("/question/quiz/{quizid}")
    List<Question> questionById(@PathVariable("quizid") Long id);
}



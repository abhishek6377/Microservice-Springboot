package com.example.demo.service;

import java.util.List;

import com.example.model.Quiz;

public interface QuizService {

	
	 Quiz quizAdd(Quiz quiz);
	 List<Quiz> getQuizs();
	 Quiz getById(long id);
	 Quiz updateQuiz(Quiz quiz,long id);
	 void deleteQuiz(long id);
	 
	
	
	
}

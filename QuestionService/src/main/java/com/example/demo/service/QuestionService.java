package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Question;

public interface QuestionService {
	
	
	Question questionSave(Question question);
	List<Question>  getallQuestion();
	Question getById(long id);
	 List<Question> getQuestionsByQuizId(long quiz);
	void deleteById(long id);
	Question Update(long id, Question question);
	  
	

}

package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionRepository;
import com.example.demo.model.Question;

@Service
public class QuestionImp implements QuestionService{
	
	
	private QuestionRepository questionRepository;

	public QuestionImp(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}

	@Override
	public Question questionSave(Question question) {
		 return questionRepository.save(question);
	}

	@Override
	public List<Question> getallQuestion() {
	   return	questionRepository.findAll();
	}

	@Override
	public Question getById(long id) {
		return questionRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(long id) {
		 questionRepository.deleteById(id);
	}

	@Override
	public Question Update(long id, Question question) {
		if(id ==0 || question == null) {
			return null;
		}
		 
		Question orElse = questionRepository.findById(id).orElse(null);
		
		
		if(question.getQuestion()!=null) {
			orElse.setQuestion(question.getQuestion());
		}
		
		return questionRepository.save(orElse);
	}

	@Override
	public List<Question> getQuestionsByQuizId(long quiz) {
      return questionRepository.getByQuiz(quiz);
	}

}

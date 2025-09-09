package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repo.QuizRepository;
import com.example.model.Quiz;

import jakarta.transaction.Transactional;

@Service
public class QuizImp implements QuizService {
	
	
	private QuizRepository quizRepository;
	
 	public QuizImp(QuizRepository quizRepository) {
		super();
		this.quizRepository = quizRepository;
	}

	@Override
	public Quiz quizAdd(Quiz quiz) {
		// TODO Auto-generated method stub
		
		if(quiz!=null) {
			quiz = quizRepository.save(quiz);
		}
		return quiz;
	}

	@Override
	public List<Quiz> getQuizs() {
		
		return quizRepository.findAll();
	}

	@Override
	public Quiz getById(long id) {
		return quizRepository.findById(id).orElse(null);
		
	}

	//@Transactional
	@Override
	public Quiz updateQuiz(Quiz quiz,long id) {
		
		System.err.println(id);
		System.out.println(quiz.toString());

		if (quiz == null || quiz.getId() == null)
			return null;

		Quiz orElse = quizRepository.findById(id).orElse(null);

		if (orElse == null) {
			return null;
		}

		if (quiz.getTitle() != null) {
			orElse.setTitle(quiz.getTitle());
		}

	  return quizRepository.save(orElse);
	}

	@Override
	public void deleteQuiz(long id) {
		if(id>0) {
			return;
		}
		
		quizRepository.deleteById(id);
		
	}

}

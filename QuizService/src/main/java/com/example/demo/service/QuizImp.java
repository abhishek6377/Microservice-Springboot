package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.FeignClient.QuestionFeignClient;
import com.example.demo.repo.QuizRepository;
import com.example.model.Quiz;

@Service
public class QuizImp implements QuizService {
	
	
    private final QuizRepository quizRepository;
    private final QuestionFeignClient questionFeignClient;

    public QuizImp(QuizRepository quizRepository, QuestionFeignClient questionFeignClient) {
        this.quizRepository = quizRepository;
        this.questionFeignClient = questionFeignClient;
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
	 List<Quiz> all = quizRepository.findAll();
	 List<Quiz> updatedQuizzes = all.stream()
			    .map(e -> {
			        e.setQuestions(questionFeignClient.questionById(e.getId()));
			        return e;
			    })
			    .collect(Collectors.toList());
	 return updatedQuizzes;
	 
	}

	@Override
	public Quiz getById(long id) {
	Quiz orElse = quizRepository.findById(id).orElse(null);
	if(orElse!=null) {
		orElse.setQuestions(questionFeignClient.questionById(orElse.getId()));
	}
	
	return orElse;
		
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

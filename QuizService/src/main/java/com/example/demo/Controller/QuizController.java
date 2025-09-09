package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.QuizService;
import com.example.model.Quiz;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/quiz")
@Slf4j
public class QuizController {

	private QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}

	@PostMapping("/save")
	public Quiz quizSave(@RequestBody Quiz entity) {
		return quizService.quizAdd(entity);
	}

	@GetMapping("/all")
	public List<Quiz> allQuiz() {
		return quizService.getQuizs();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuiz(@PathVariable long id) {
		quizService.deleteQuiz(id);
		return ResponseEntity.ok("Quiz deleted successfully");
	}
	
	@GetMapping("/{id}")
	public Quiz getById(@PathVariable long id) {
		return quizService.getById(id);
	}
	
	@PutMapping("/update/{id}")
	public Quiz updateQuiz(@RequestBody Quiz entity,@PathVariable long id) {
		return quizService.updateQuiz(entity,id);
	}
	

}

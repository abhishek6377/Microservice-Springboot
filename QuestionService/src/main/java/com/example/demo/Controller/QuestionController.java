package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/question")
public class QuestionController {
	
	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	  
	
	
	@PostMapping("/save")
	public Question saveQuestion(@RequestBody Question entity) {
		return questionService.questionSave(entity);
	}
	
	
	@GetMapping("/all")
	public List<Question> allQuestion() {
		return questionService.getallQuestion();
	}
	
	@GetMapping("/quiz/{quizid}")
    public List<Question> getQuestionsByQuizId(@PathVariable Long quizid) {
        return questionService.getQuestionsByQuizId(quizid);
    }
	
	@GetMapping("/{id}")
	public Question getMethodName(@PathVariable long id) {
		 return questionService.getById(id);
	}
	
	
	@DeleteMapping("/{id}")
	 ResponseEntity<String>  deleteQuestion(@PathVariable long id){
		  questionService.deleteById(id);
		  return ResponseEntity.ok("Question Deleted Succesfully.");
	}
	
	@PutMapping("/update/{id}")
	public Question putMethodName(@PathVariable long id, @RequestBody Question entity) {
		return questionService.Update(id, entity);
	}
	
	
	  

}

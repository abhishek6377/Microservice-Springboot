package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Question;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, Long>{
	
//	List<Question> findByQuizId(Long quizId);
	
    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM question WHERE quiz_id = ?1", nativeQuery = true)
    List<Question> getByQuiz(Long quizId);
    
    

}

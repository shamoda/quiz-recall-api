package com.app.quizrecall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class QuizrecallApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizrecallApplication.class, args);
	}

}

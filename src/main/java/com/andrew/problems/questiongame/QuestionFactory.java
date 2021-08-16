package com.andrew.problems.questiongame;

import java.util.HashMap;
import java.util.Map;

public class QuestionFactory {
	int questionNo;
	String question;
	HashMap<String, String> options;
	String correctAnswer;

	public QuestionFactory(int questionNo, String question, Map<String, String> options, String correctAnswer) {
		this.questionNo = questionNo;
		this.question = question;
		this.options = new HashMap<>(options);
		this.correctAnswer = correctAnswer;
	}

}

package com.andrew.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class QuestionFactory {
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

public class QuestionGame {
	private QuestionFactory[] questions = null;
	private Scanner scanner = null;
	private Map<Integer, String> answered = null;
	private ArrayList<Integer> correct = null;
	private ArrayList<Integer> wrong = null;

	public QuestionGame() {
		questions = createQuestions();
		scanner = new Scanner(System.in);
		answered = new HashMap<>();
		correct = new ArrayList<>();
		wrong = new ArrayList<>();
	}

	public QuestionFactory[] createQuestions() {
		// Question 1
		Map<String, String> option1 = new HashMap<>();
		option1.put("a", "Modi");
		option1.put("b", "Rahul");
		option1.put("c", "Mamata");

		QuestionFactory question1 = new QuestionFactory(1, "Who is the PM of India?", option1, "a");

		// Question 2
		Map<String, String> option2 = new HashMap<>();
		option2.put("a", "Modi");
		option2.put("b", "Trump");
		option2.put("c", "None");

		QuestionFactory question2 = new QuestionFactory(2, "Who is the President of USA?", option2, "c");

		// Question 3
		Map<String, String> option3 = new HashMap<>();
		option3.put("a", "2");
		option3.put("b", "10");
		option3.put("c", "11");

		QuestionFactory question3 = new QuestionFactory(3, "What is 1 + 1?", option3, "b");

		return new QuestionFactory[] { question1, question2, question3 };
	}

	public void showQuestions() {
		for (QuestionFactory question : questions) {
			System.out.println(question.question);
			for (String key : question.options.keySet()) {
				String value = question.options.get(key);
				System.out.println(key + ": " + value);
			}

			System.out.println("Enter an option");
			String answeredOption = scanner.nextLine();

			answered.put(question.questionNo, answeredOption);
		}
	}

	public void evaluateAnswers() {
		for (Integer answerKey : answered.keySet()) {
			QuestionFactory question = null;

			for (QuestionFactory q : this.questions) {
				if (q.questionNo == answerKey) {
					question = q;
					break;
				}
			}

			if (question == null) {
				System.out.println("Question error");
				return;
			}

			if ((question.correctAnswer).equals(answered.get(answerKey))) {
				correct.add(question.questionNo);
			} else {
				wrong.add(question.questionNo);
			}
		}
	}

	public void displayResults() {
		System.out.println("\nRight: " + correct.size());
		System.out.println("Wrong: " + wrong.size());

		for (Integer i : wrong) {
			QuestionFactory question = null;

			for (QuestionFactory q : questions) {
				if (q.questionNo == i) {
					question = q;
					break;
				}
			}

			if (question == null) {
				System.out.println("Question error");
				return;
			}

			System.out.println(question.question);
			System.out.println("Correct Answer: " + question.options.get(question.correctAnswer));
		}
	}

	public boolean shouldContinue() {
		System.out.println("\nTry again? (Y/n)");

		return !(scanner.nextLine().equalsIgnoreCase("n"));
	}

	public void resetScores() {
		answered.clear();
		correct.clear();
		wrong.clear();
	}

	public void startGame() {
		QuestionGame questionGame = new QuestionGame();

		try {
			do {
				System.out.println("Let's play a game.");

				questionGame.resetScores();

				questionGame.showQuestions();

				questionGame.evaluateAnswers();

				questionGame.displayResults();
			} while (questionGame.shouldContinue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.andrew.problems.questiongame;

public interface QuestionGameOperations {
	public QuestionFactory[] createQuestions();

	public void showQuestions();

	public void evaluateAnswers();

	public void displayResults();

	public boolean shouldContinue();

	public void resetScores();

	public void startGame();
}

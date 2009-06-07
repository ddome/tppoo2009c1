package questions;

import player.*;

import java.io.File;

public class Quiz {
	
	private Question quiz[];
	private int index;
	private int score;
	private boolean answers[];
	private Game game;
	Ranking ranking;
		
	public Quiz(String user,int level,Question q[],File rankingFile) {
		index = 0;
		score = 0;
		quiz = q;
		answers = new boolean[quiz.length];
		ranking = new Ranking(rankingFile);
		game = new Game(user,level);
	}
	
	public Question getActualQuestion() {
		
		if( index < quiz.length )
			return quiz[index];
		else
			return null;
	}
		
	public void answerActualQuestion(Object answer) {
		
		if( index < quiz.length ) {
			if( quiz[index].isCorrect(answer) ) {
				score+=quiz[index].getScore();
				answers[index] = true;
			}
			else
				answers[index] = false;
				
			index++;	
			if( index == quiz.length  ) {
				game.setScore(score);
				ranking.saveScore(game);
			}
		}		
	}
	
	public String[] getQuestions() {	
		String q[]  = new String[quiz.length];
		
		for(int i=0;i<quiz.length;i++ ) {
			q[i] = quiz[i].getQuestion();
		}		
		return q;
	}
	
	public boolean questionExists() {
		return (index < quiz.length);
	}
	
	public boolean[] getAnswers() {			
	
		return answers;
	}
	
	public void restart() {
		index = 0;
		score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
}

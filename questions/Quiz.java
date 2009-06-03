package questions; 

public class Quiz {
	
	private Question quiz[];
	private int index;
	private int score;
	private boolean answers[];
	
	public Quiz(Question q[]) {
		index = 0;
		score = 0;
		quiz = q;
		answers = new boolean[quiz.length];
	}
	
	public Question getActualQuestion() {
		
		if( index < quiz.length )
			return quiz[index];
		else
			return null;
	}
		
	public void answerActualQuestion(Object answer) {
		if( quiz[index].isCorrect(answer) ) {
			score+=quiz[index].getScore();
			answers[index] = true;
		}
		else
			answers[index] = false;
			
		index++;
	}
	
	public String[] getQuestions() {	
		String q[]  = new String[10];
		
		for(int i=0;i<quiz.length;i++ ) {
			q[i] = quiz[i].getQuestion();
		}		
		return q;
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

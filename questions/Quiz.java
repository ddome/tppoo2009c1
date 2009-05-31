package questions; 

public class Quiz {
	
	private Question quiz[];
	private int index;
	private int score;
	
	public Quiz(Question q[]) {
		index = -1;
		score = 0;
		quiz = q;
	}
	
	public String getNextQuestion() {
		index++;
		
		if( index < quiz.length )
			return quiz[index].getQuestion();
		else
			return null;
	}
		
	public void setAnswer(Object answer) {
		if( quiz[index].isCorrect(answer) )
			score+=quiz[index].getScore();
	}
	
	public String[] getQuestions() {	
		String q[]  = new String[10];
		
		for(int i=0;i<quiz.length;i++ ) {
			q[i] = quiz[i].getQuestion();
		}		
		return q;
	}
	
	public void restart() {
		index = -1;
		score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
}

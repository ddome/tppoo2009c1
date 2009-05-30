package questions;

public class SimpleNumberQuestion extends Question {

	private Number answer;
	
	public SimpleNumberQuestion(String question, Number answer, int level){
		super(question,level);
		this.answer = answer;
	
	}
	
	public void setAnswer(Number answer){
		this.answer = answer;
	}
	
	public boolean isCorrect(Object answer){
		if( answer instanceof Number  )
			return this.answer.equals(answer);
		else
			return false;
	}
	
	public boolean isCorrect(Number answer){
		return this.answer.equals(answer);
	}
}

package questions;

public class SimpleTextQuestion extends Question {

	private String answer;
	
	public SimpleTextQuestion(String question, String answer, int level){
		super(question,level);
		this.answer = answer;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;
	}
	
	public boolean isCorrect(Object answer){
		if( answer instanceof String ) 
			return this.answer.toLowerCase().equals(((String)answer).toLowerCase());
		else
			return false;
	}
	
	public boolean isCorrect(String answer){
		return this.answer.toLowerCase().equals(answer.toLowerCase());
	}
		
}

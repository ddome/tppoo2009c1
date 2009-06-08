package questions;
public class BooleanQuestion extends Question{
	
	private Boolean answer;
	
	public BooleanQuestion(String question, Boolean answer, int level,int score){
		super(question,level,score);
		this.answer = answer;	
	}
	
	public void setAnswer(Boolean answer){
		this.answer = answer;
	}
	
	public Boolean getAnswer(){
		return this.answer;
	}
	
	public boolean isCorrect(Object answer){
		if( answer instanceof Boolean )
			return this.answer.equals(answer);
		else
			return false;
	}
	
	public boolean isCorrect(Boolean answer){
		return this.answer.equals(answer);
	}
	
}

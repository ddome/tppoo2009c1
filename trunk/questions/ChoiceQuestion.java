package questions;

public abstract class ChoiceQuestion extends Question {
	
	String choices[];
	
	public ChoiceQuestion(String question, String choices[], int level,int score){
		super(question,level,score);
		this.choices = choices;
	}
}

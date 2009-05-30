package questions;

public abstract class ChoiceQuestion extends Question {
	
	String choices[];
	
	public ChoiceQuestion(String question, String choices[], int level){
		super(question,level);
		this.choices = choices;
	}
}

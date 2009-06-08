package questions;

import java.util.Arrays;

public abstract class ChoiceQuestion extends Question {
	
	String choices[];
	
	public ChoiceQuestion(String question, String choices[], int level,int score){
		super(question,level,score);
		this.choices = choices;
	}
	
	public boolean equals(Object o) {
		if( !(o instanceof ChoiceQuestion) )
			return false;
		if( !Arrays.equals(this.choices,((ChoiceQuestion)o).choices) )
			return false;
		return super.equals(o);
	}
	
	public String[] getChoices(){
		return choices;
	}
	
}

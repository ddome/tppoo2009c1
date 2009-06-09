package questions;

import java.util.Arrays;
import java.util.HashSet;

public abstract class ChoiceQuestion extends Question {
	
	protected HashSet<String> choices = new HashSet<String>();

	public ChoiceQuestion(String question, String choices[], int level,int score){
		super(question,level,score);
		
		for( String choice: choices) {		
			this.choices.add(choice);
		}		
	}
	
	public boolean equals(Object o) {
		
		String[] choices = new String[this.choices.size()];
		choices = this.choices.toArray(choices);
			
		if( !(o instanceof ChoiceQuestion) )
			return false;
		if( !Arrays.equals(choices,((ChoiceQuestion)o).getChoices()) )
			return false;
		return super.equals(o);
	}
	
	public String[] getChoices(){
		
		String[] choices = new String[this.choices.size()];
		choices = this.choices.toArray(choices);
		
		return choices;
	}
	
}

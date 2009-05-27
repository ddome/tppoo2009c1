package Quiz;

public abstract class ChoiceQuestion<T> extends Question<T> {
	
	String choices[];
	
	public ChoiceQuestion(String question, String choices[], int level){
		super(question,level);
		this.choices = choices;
	}
}

package Quiz;

public abstract class ChoiceQuestion<T> extends Question<T> {
	
	String choices[];
	
	public ChoiceQuestion(String question, String choices[], int level,int id){
		super(question,level,id);
		this.choices = choices;
	}
}

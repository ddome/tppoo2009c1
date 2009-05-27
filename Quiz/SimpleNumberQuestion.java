package Quiz;

public class SimpleNumberQuestion extends Question<Number> {

	private Number answer;
	
	public SimpleNumberQuestion(String question, Number answer, int level){
		super(question,level);
		this.answer = answer;
	
	}
	
	public void setAnswer(Number answer){
		this.answer = answer;
	}
	
	public boolean isCorrect(Number answer){
		return this.answer.equals(answer);
	}
}

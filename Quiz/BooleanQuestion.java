package Quiz;
public class BooleanQuestion extends Question<Boolean>{
	
	private Boolean answer;
	
	public BooleanQuestion(String question, Boolean answer, int level){
		super(question,level);
		this.answer = answer;	
	}
	
	public void setAnswer(Boolean answer){
		this.answer = answer;
	}
		
	public boolean isCorrect(Boolean answer){
		return this.answer.equals(answer);
	}
}

package Quiz;
public class BooleanQuestion extends Question<Boolean>{
	
	private Boolean answer;
	
	public BooleanQuestion(String question, Boolean answer, int level, int id){
		super(question,level,id);
		this.answer = answer;	
	}
	
	public void setAnswer(Boolean answer){
		this.answer = answer;
	}
		
	public boolean isCorrect(Boolean answer){
		return this.answer.equals(answer);
	}
}

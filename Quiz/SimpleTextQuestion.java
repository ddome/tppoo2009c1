package Quiz;

public class SimpleTextQuestion extends Question<String> {

	private String answer;
	
	public SimpleTextQuestion(String question, String answer, int level){
		super(question,level);
		this.answer = answer;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;
	}
		
	public boolean isCorrect(String answer){
		return this.answer.toLowerCase().equals(answer.toLowerCase());
	}
		
}

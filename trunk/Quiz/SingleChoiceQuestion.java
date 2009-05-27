package Quiz;

public class SingleChoiceQuestion extends ChoiceQuestion<Integer>{
	
	// answer not set
	private Integer answer = -1;
	
	public SingleChoiceQuestion(String question,String choices[],Integer answer, int level){
		super(question,choices,level);
		this.answer = answer;	
	}
	
	public void setAnswer(Integer answer){
		if( answer < this.choices.length)
			this.answer = answer;
	}
		
	public boolean isCorrect(Integer answer){
		return this.answer.equals(answer);
	}
}

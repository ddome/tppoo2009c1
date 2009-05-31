package questions;

public class SingleChoiceQuestion extends ChoiceQuestion{
	
	// answer not set
	private Integer answer = -1;
	
	public SingleChoiceQuestion(String question,String choices[],Integer answer, int level,int score){
		super(question,choices,level,score);
		this.answer = answer;	
	}
	
	public void setAnswer(Integer answer){
		if( answer < this.choices.length)
			this.answer = answer;
	}
	
	public boolean isCorrect(Object answer){
		return this.answer.equals(answer);
	}
	
	public boolean isCorrect(Integer answer){
		return this.answer.equals(answer);
	}
}

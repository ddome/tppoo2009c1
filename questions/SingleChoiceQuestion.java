package questions;

import java.io.BufferedWriter;
import java.io.IOException;

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
	
	public Integer getAnswer(){
		return answer;
	}
	
	public void WriteToFile(BufferedWriter outFile) throws IOException{
		int i;
		String[] choices = this.getChoices();
		outFile.write("3");
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getLevel()).toString());
		outFile.newLine();
		outFile.write(Integer.valueOf(choices.length).toString());
		outFile.newLine();
		outFile.write("1");
		outFile.newLine();
		outFile.write(this.getQuestion());
		outFile.newLine();
		for(i=0;i<choices.length;i++){
			outFile.write(choices[i]);
			outFile.newLine();
		}
		outFile.write(choices[this.getAnswer()]);
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getScore()).toString());
		outFile.newLine();
	}
}

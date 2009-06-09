package questions;

import java.io.BufferedWriter;
import java.io.IOException;

public class SingleChoiceQuestion extends ChoiceQuestion{
	
	private String answer;
	
	public SingleChoiceQuestion(String question,String choices[],String answer, int level,int score){
		super(question,choices,level,score);
		
		this.setAnswer(answer);
	}
	
	public void setAnswer(String answer){
		
		if( super.choices.contains(answer))
			this.answer = answer;
	}
	
	public boolean isCorrect(Object answer){
		return this.answer.equals(answer);
	}
	
	public boolean isCorrect(Integer answer){
		return this.answer.equals(answer);
	}
	
	public String getAnswer(){
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

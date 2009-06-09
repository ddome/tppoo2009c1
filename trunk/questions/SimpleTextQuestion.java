package questions;

import java.io.BufferedWriter;
import java.io.IOException;

public class SimpleTextQuestion extends Question {

	private String answer;
	
	public SimpleTextQuestion(String question, String answer, int level,int score){
		super(question,level,score);
		this.answer = answer;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;
	}
	
	public String getAnswer(){
		return new String(this.answer);
	}
	
	public boolean isCorrect(Object answer){
		if( answer instanceof String ) 
			return this.answer.toLowerCase().equals(((String)answer).toLowerCase());
		else
			return false;
	}
	
	public boolean isCorrect(String answer){
		return this.answer.toLowerCase().equals(answer.toLowerCase());
	}
		
	public void WriteToFile(BufferedWriter outFile) throws IOException{
		outFile.write("1");	
		outFile.write(this.getLevel());
		outFile.write("1");
		outFile.write("1");
		outFile.write(this.getQuestion());
		outFile.write(this.getAnswer());
		outFile.write(this.getAnswer());
		outFile.write(this.getScore());
	}
}

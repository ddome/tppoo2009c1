package questions;

import java.io.BufferedWriter;
import java.io.IOException;

public class SimpleNumberQuestion extends Question {

	private Number answer;
	
	public SimpleNumberQuestion(String question, Number answer, int level, int score){
		super(question,level,score);
		this.answer = answer;
	
	}
	
	public void setAnswer(Number answer){
		this.answer = answer;
	}
	
	public Number getAnswer(){
		return this.answer;
	}
	
	public boolean isCorrect(Object answer){
		if( answer instanceof Number  )
			return this.answer.equals(answer);
		else
			return false;
	}
	
	public boolean isCorrect(Number answer){
		return this.answer.equals(answer);
	}
	
	public void WriteToFile(BufferedWriter outFile) throws IOException{
		outFile.write("2");
		outFile.write(this.getLevel());
		outFile.write("1");
		outFile.write("1");
		outFile.write(this.getQuestion());
		outFile.write(this.getAnswer().toString());
		outFile.write(this.getAnswer().toString());
		outFile.write(this.getScore());
	}
}

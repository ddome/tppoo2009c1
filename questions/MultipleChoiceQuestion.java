package questions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*; 

public class MultipleChoiceQuestion extends ChoiceQuestion{

	private HashSet<String> answers = new HashSet<String>();
		
	public MultipleChoiceQuestion(String question,String choices[],String answers[], int level, int score){
		super(question,choices,level,score);
		
		for( String answer: answers) {	
			this.addAnswer(answer);
		}		
	}
	
	public void addAnswer(String answer){
		if( super.choices.contains(answer)  )
			this.answers.add(answer);	
	}
	
	public boolean isCorrect(Object answers) {
		if( answers instanceof String[] )
			return isCorrect((String[])answers);
		else
			return false;
	}
		
	public boolean isCorrect(String answers[]){
		
		boolean ret = true;
		
		for( String answer: answers ) {
			if( !this.answers.contains(answer) ){
				ret = false;
				break;
			}		
		}
		
		return ret;
	}
	
	public String[] getAnswers(){
		
		String aux[] = new String[(answers.size())];	
		aux = answers.toArray(aux);
		
		return aux;
	}
	
	public void WriteToFile(BufferedWriter outFile) throws IOException{
		int i;
		String[] choices = this.getChoices();
		Integer[] answers = this.getAnswers();
		outFile.write("4");
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getLevel()).toString());
		outFile.newLine();
		outFile.write(Integer.valueOf(choices.length).toString());
		outFile.newLine();
		outFile.write(Integer.valueOf(answers.length).toString());
		outFile.newLine();
		outFile.write(this.getQuestion());
		outFile.newLine();
		for(i=0;i<choices.length;i++){
			outFile.write(choices[i]);
			outFile.newLine();
		}
		for(i=0;i<answers.length;i++){
			outFile.write(choices[answers[i]]);
			outFile.newLine();
		}
		outFile.write(Integer.valueOf(this.getScore()).toString());
		outFile.newLine();
	}
}

package questions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*; 

public class MultipleChoiceQuestion extends ChoiceQuestion{

	private LinkedList<Integer> answers = new LinkedList<Integer>();
	
	public MultipleChoiceQuestion(String question,String choices[],Integer answers[], int level, int score){
		super(question,choices,level,score);
		
		for( Integer answer: answers ) {
			//Verifico que cada respuesta este dentro de las opciones disponibles
			if( answer < choices.length + 1 )
				this.answers.add(answer);
		}		
	}
	
	public void addAnswer(int answer){
		if( answer < choices.length + 1 )
			this.answers.add(new Integer(answer));
	}
	
	public boolean isCorrect(Object answers) {
		if( answers instanceof Integer[] )
			return isCorrect((Integer[])answers);
		else
			return false;
	}
		
	public boolean isCorrect(Integer answers[]){
		
		boolean ret = true;
		
		for( Integer answer: answers ) {
			if( !this.answers.contains(answer) ){
				ret = false;
				break;
			}		
		}
		
		return ret;
	}
	
	public Integer[] getAnswers(){
		
		Integer aux[] = new Integer[(answers.size())];	
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

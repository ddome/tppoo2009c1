package questions;
import java.util.*; 

public class MultipleChoiceQuestion extends ChoiceQuestion{

	private LinkedList<Integer> answers = new LinkedList<Integer>();
	
	public MultipleChoiceQuestion(String question,String choices[],Integer answers[], int level){
		super(question,choices,level);
		
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
			return isCorrect(answers);
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
}
